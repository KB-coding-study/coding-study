import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = 1;
            map[v][u] = 1;
        }

        int count = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static void DFS(int node){
        visited[node] = true;
        for(int i = 1; i < N + 1; i++){
            if(visited[i] || map[node][i] != 1)
                continue;DFS(i);
        }
    }
}