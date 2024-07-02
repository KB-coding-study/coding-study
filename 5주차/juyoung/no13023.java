import java.io.*;
import java.util.*;

public class no13023 {

    static int N, M, answer = 0;
    static List<Integer>[] people;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        people = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            people[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String inputFriend = br.readLine();
            int a, b;
            a = Integer.parseInt(inputFriend.split(" ")[0]);
            b = Integer.parseInt(inputFriend.split(" ")[1]);
            people[a].add(b);
            people[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (answer == 1) break;
            Arrays.fill(visited, false);
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int node, int depth) {
        if (depth >= 4) {
            answer = 1;
            return;
        }
        visited[node] = true;
        for (int neighbor : people[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, depth + 1);
                if (answer == 1) return;
            }
        }
        visited[node] = false;
    }
}
