import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int result = 0;
    static int[][] arr, d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<int[]> virus = new ArrayList<>();

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j])
                    continue;

                for (int k = 0; k < virus.size(); k++) {
                    int[] temp = virus.get(k);
                    q.add(new int[]{temp[0], temp[1]});
                    visited[temp[0]][temp[1]] = true;
                }

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nr = now[0] + d[k][0];
                        int nc = now[1] + d[k][1];

                        if(nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] != 0 || visited[nr][nc])
                            continue;

                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }

                int count = 0;
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < m; b++) {
                        if(arr[a][b] == 0 && !visited[a][b])
                            count++;
                    }
                }
                result = Math.max(result, count);
            }
        }
    }

    public static void bt(int r, int c, int count){
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = r; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == r && j < c)
                    continue;

                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    bt(i, j, count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 2)
                    virus.add(new int[]{i, j});
            }
        }

        bt(0, 0, 0);
        System.out.println(result);
    }
}