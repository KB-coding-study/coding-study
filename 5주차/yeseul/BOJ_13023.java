import java.io.*;
import java.util.*;

public class BOJ_13023 {
    static int n, m;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static boolean isExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n];


        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        visited = new boolean[n];
        isExist = false;

        for (int i = 0; i < n; i++) {
            if (!isExist) dfs(i, 0);
        }

        if (isExist) System.out.println(1);
        else System.out.println(0);
    }

    public static void dfs(int start, int depth) {
        visited[start] = true;

        if (depth == 4) {
            isExist = true;
            return;
        }

        for (int n : map[start]) {
            if (!visited[n]){
                dfs(n, depth + 1);
                if (isExist) return;
            }
        }
        visited[start] = false;
    }
}
