import java.io.*;
import java.util.*;

public class Main {
    static int T, n, count;
    static int[] choice;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            choice = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                choice[j] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }
            sb.append(n - count).append("\n");
            for(int j = 1; j <= n; j++){
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;
        int end = choice[start];

        if (!visited[end]) {
            dfs(end);
        }
        else if (!finished[end]) {
            for (int i = end; i != start; i = choice[i]) {
                count++;
            }
            count++;
        }

        finished[start] = true;
    }
}
