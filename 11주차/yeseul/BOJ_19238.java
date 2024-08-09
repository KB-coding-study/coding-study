import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238 {
    // 택시와 승객의 시작 위치가 같을 수 있음 => 0칸
    // 승객을 목적지로 이동시킨 동시에 연료가 바닥나는 경우는 성공
    // 택시의 위치에서 여러 승객까지의 최단거리가 같을 때, 번호가 더 작은 승객으로 이동
    static int n, m, fuel;
    static int[] start;
    static int[][] map;
    static int[][] tmp;
    static int[][] passen;
    static int[][] passengerMap;
    static boolean flag;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        start = new int[2];
        passen = new int[m][4];
        passengerMap = new int[n][n];
        flag = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            passengerMap[sx][sy] = i + 1;
            passen[i][0] = sx;
            passen[i][1] = sy;
            passen[i][2] = ex;
            passen[i][3] = ey;
        }

        for (int i = 0; i < m; i++) {
            decidePassenger();
            if (flag) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(fuel);
    }

    // 택시에서부터 승객까지 최단거리 탐색
    static void decidePassenger() {
        for (int i = 0; i < m; i++) {
            if (passen[i][0] == start[0] && passen[i][1] == start[1]) bfs(i);
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        tmp[start[0]][start[1]] = 1;
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + xy[0];
                int ny = dy[i] + xy[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] == 1) continue;
                if (visited[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                tmp[nx][ny] = tmp[xy[0]][xy[1]] + 1;
            }
        }
        ridePassenger();
    }

    // 최단거리 승객 태우러 택시 위치 바꾸기, 연료 소모
    static void ridePassenger() {
        int min = Integer.MAX_VALUE;
        int passNum = -1;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                if (passengerMap[i][j] != 0) {
                    if (tmp[i][j] != 0 && tmp[i][j] < min) {
                        min = tmp[i][j];
                        passNum = passengerMap[i][j];
                    } else if (tmp[i][j] == min) {
                        passNum = Math.min(passNum, passengerMap[i][j]);
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            // 모든 손님을 이동시킬 수 없는 경우
            flag = true;
        } else {
            start[0] = passen[passNum][0];
            start[1] = passen[passNum][1];
            fuel -= min;
            bfs(passNum);
        }
    }


    // 승객 위치부터 목적지까지 최단거리
    static void bfs(int num) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        q.offer(new int[]{passen[num][0], passen[num][1]});
        visited[passen[num][0]][passen[num][1]] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + xy[0];
                int ny = dy[i] + xy[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (tmp[nx][ny] == 1) continue;
                if (visited[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                tmp[nx][ny] = tmp[xy[0]][xy[1]] + 1;
            }
        }
        setFuel(num);
    }

    // 남은 연료 확인, 책시에 연료 충전
    static void setFuel(int num) {
        fuel -= tmp[passen[num][2]][passen[num][3]];
        if (fuel < 0) {
            flag = true;
            return;
        }
        start[0] = passen[num][2];
        start[1] = passen[num][3];
        fuel += tmp[passen[num][2]][passen[num][3]] + tmp[passen[num][2]][passen[num][3]];
    }
}
