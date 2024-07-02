import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        bw.write(String.valueOf(DFS(1) - 1));
        bw.flush();
        bw.close();
    }

    static int DFS(int node) {
        visited[node] = true;
        int count = 1;

        for (int i = 1; i <= n; i++) {
            if (map[node][i] == 1 && !visited[i]) {
                count += DFS(i);
            }
        }

        return count;
    }
}
