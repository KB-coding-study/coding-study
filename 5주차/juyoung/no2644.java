import java.io.*;
import java.util.*;

public class no2644 {

    static int N,M, answer = -1;
    static int[][] family, visited;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        family = new int[N+1][N+1];
        visited = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            family[parent][child] = 1;
            family[child][parent] = 1;
        }

        dfs(start, end, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int end, int cnt) {
        if (start == end) {
            answer = cnt;
        }
        else {
            for (int i = 0; i < N + 1; i++) {
                if (family[start][i] == 1 && visited[start][i] == 0) {
                    visited[i][start] = 1;
                    dfs(i, end, cnt + 1);
                }
            }
        }
    }
}
