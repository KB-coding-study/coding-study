import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int[][] graph; // 그래프배열
    static boolean[] visited; //방문한 자리
    static int count = 0; // 연결요소의 개수

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1; // 편하게 하기위해 -1
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) { //방문하지 않은 자리라면 bfs함수 실행 후 count++;
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>(); // 큐 선언
        q.offer(start); //큐에 삽입
        visited[start] = true; //방문한곳 표시

        // 해당 기준으로 연결된 지점을 확인
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < N; i++) {
                if (graph[tmp][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}