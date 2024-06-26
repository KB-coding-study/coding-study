import java.util.*;

public class BOJ2606 {
    static boolean[] visited; // 방문 여부를 체크하는 배열
    static ArrayList<Integer>[] graph; // 인접 리스트를 사용한 그래프 표현
    static int count = 0; // 감염된 컴퓨터 수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 컴퓨터의 수
        int m = scanner.nextInt(); // 간선의 수

        visited = new boolean[n + 1]; // 컴퓨터 번호가 1번부터 시작하므로 n+1 크기 배열
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1); // 1번 컴퓨터부터 탐색 시작

        System.out.println(count - 1); // 1번 컴퓨터 제외한 감염된 컴퓨터 수 출력
    }

    public static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}