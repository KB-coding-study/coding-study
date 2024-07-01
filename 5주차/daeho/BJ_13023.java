import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> list;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            DFS(i, 1);
            if(found)
                break;

        }

        if (found)
            bw.write("1");
        else
            bw.write("0");
        bw.flush();
        bw.close();
    }

    static void DFS(int node, int count) {
        if (count >= 5) {
            found = true;
        }
        visited[node] = true;
        for (int next : list.get(node)) {
            if (!visited[next]) {
                if (!found) {
                    DFS(next, count + 1);
                }
            }
        }
        visited[node] = false;
    }
}
