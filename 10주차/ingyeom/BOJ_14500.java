import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int sum = 0, result = 0;

    public static void dfs(int r, int c, int depth, int direct) {
        if (depth == 4) {
            result = Math.max(result, sum + arr[r][c]);
            return;
        }

        visited[r][c] = true;
        sum += arr[r][c];

        for (int i = 0; i < 4; i++) {
            int nr = r + d[i][0];
            int nc = c + d[i][1];

            if(nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length || visited[nr][nc])
                continue;

            dfs(nr, nc, depth + 1, i);
        }

        if (depth == 2) {
            if (direct == 1) {
                int nr = r + 1;

                if(nr >= 0 && nr < arr.length && !visited[nr][c]){
                    sum += arr[nr][c];

                    int nc1 = c + 1;
                    if(nc1 >= 0 && nc1 < arr[0].length && !visited[r][nc1]){
                        result = Math.max(result, sum + arr[r][nc1]);
                    }

                    int nc2 = c - 1;
                    if(nc2 >= 0 && nc2 < arr[0].length && !visited[r][nc2]){
                        result = Math.max(result, sum + arr[r][nc2]);
                    }

                    sum -= arr[nr][c];
                }
            }
            else if(direct == 3) {
                int nc = c + 1;

                if(nc >= 0 && nc < arr[0].length && !visited[r][nc]){
                    sum += arr[r][nc];

                    int nr1 = r + 1;
                    if(nr1 >= 0 && nr1 < arr.length && !visited[nr1][c]){
                        result = Math.max(result, sum + arr[nr1][c]);
                    }

                    int nr2 = r - 1;
                    if(nr2 >= 0 && nr2 < arr.length && !visited[nr2][c]){
                        result = Math.max(result, sum + arr[nr2][c]);
                    }

                    sum -= arr[r][nc];
                }
            }
        }

        visited[r][c] = false;
        sum -= arr[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 1, -1);
            }
        }
        System.out.println(result);
    }
}