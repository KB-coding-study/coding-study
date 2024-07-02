import java.io.*;
import java.util.*;
public class no11724 {

    static int N, M;
    static int[][] vertex;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vertex = new int[N+1][N+1];
        visited = new int[N+1];

        int start, end;
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            vertex[start][end] = 1;
            vertex[end][start] = 1;
        }

        int answer = 0;
        for (int i = 1 ; i < N+1 ; i++) {
            if (visited[i]==0) {
                dfs(i);
                answer+=1;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int node) {
        visited[node] = 1;
        for (int i = 0 ; i < N+1 ; i++) {
            if(vertex[node][i] == 1 && visited[i]==0) {
                dfs(i);
            }
        }
    }
}
