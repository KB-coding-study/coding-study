import java.io.*;
import java.util.*;

public class BOJ_17142 {
    // 0: 빈칸, -1: 벽, -2: 바이러스 비활성상태, -3: 바이러스 활성상태
    static int n, m, result;
    static List<int[]> virusDis;
    static int[][] map;
    static int[][] tmp;
    static int[] selected;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        virusDis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int t = Integer.parseInt(st.nextToken());
                switch (t) {
                    case 1:
                        map[i][j] = -1;
                        break;
                    case 2:
                        virusDis.add(new int[]{i, j});
                        map[i][j] = -2;
                        break;
                    default:
                        map[i][j] = 0;
                }
            }
        }

        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    result = Integer.MAX_VALUE;
                    selected = new int[m];
                    break;
                }
            }
        }
        if (result == Integer.MAX_VALUE) dfs(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    // 0. 활성상태 만들 바이러스 짝 조합
    static void dfs(int s, int cnt) {
        if (cnt == m) {
            // map 복사
            tmp = new int[n][n];
            for (int i = 0; i < n; i++) {
                tmp[i] = map[i].clone();
            }

            // 1. 바이러스 활성상태 만들기
            activeVirus();
            return;
        }

        for (int i = s; i < virusDis.size(); i++) {
            selected[cnt] = i;
            dfs(i + 1, cnt + 1);
        }
    }

    // 1. 바이러스 활성상태 만들기
    static void activeVirus() {
        // 1. 바이러스 활성상태 짝 확인 후 활성상태 만들기
        Queue<int[]> q = new LinkedList<>();
        for (int idx : selected) {
            int[] virus = virusDis.get(idx);
            q.offer(new int[]{virus[0], virus[1], 0});  // {바이러스의 x위치, y위치, 시작 시간}
            tmp[virus[0]][virus[1]] = -3;
        }

        // 2. 활성상태인 바이러스 퍼뜨리기
        int maxDis = bfs(q);

        // 3. 빈 칸 확인 후, 빈 칸이 없으면 최소시간 구하기
        if (checkEmpty()) result = Math.min(result, maxDis);
    }

    // 2. 바이러스 퍼뜨리기
    static int bfs(Queue<int[]> q) {
        int maxDis = 0;
        boolean[][] visited = new boolean[n][n];

        while (!q.isEmpty()) {
            int[] xyt = q.poll();
            maxDis = Math.max(maxDis, xyt[2]);

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + xyt[0];
                int ny = dy[i] + xyt[1];
                boolean flag = false;

                if (nx >= n || ny >= n || nx < 0 || ny < 0) continue;
                if (visited[nx][ny]) continue;
                if (tmp[nx][ny] == -1) continue;

                // 비활성 바이러스 => 지나가면서 시간 + 1할 수는 있는데, 갈 필요 없으면 가지 않음
                // 비활성 바이러스 옆에 빈 칸 확인
                if (tmp[nx][ny] == -2) {
                    for (int j = 0; j < 4; j++) {
                        int nnx = dx[j] + nx;
                        int nny = dy[j] + ny;
                        if (nnx >= n || nny >= n || nnx < 0 || nny < 0) continue;

                        // 비활성 바이러스 옆에 빈 칸이 있을 때 => 비활성 바이러스 칸도 경로에 포함(비활성 바이러스 활성화)
                        if (tmp[nnx][nny] == 0) {
                            tmp[nx][ny] = 0;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) tmp[nx][ny] = -3;
                }

                if (tmp[nx][ny] == 0 || tmp[nx][ny] == -2) {
                    visited[nx][ny] = true;
                    if (tmp[nx][ny] == 0) q.offer(new int[]{nx, ny, xyt[2] + 1});
                    else q.offer(new int[]{nx, ny, xyt[2]});
                    tmp[nx][ny] = -3;
                }
            }
        }
        return maxDis;
    }

    // 3. 0인 칸(빈 칸)이 있는지 확인 후, 있으면 false, 없으면 true 반환
    static boolean checkEmpty() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 0) return false;
            }
        }
        return true;
    }
}
