import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int N, x, y, m;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = 1;
            map[v][u] = 1;
        }

        bw.write(String.valueOf(DFS(x, 0)));
        bw.flush();
        bw.close();
    }

    static int DFS(int node, int count){
        visited[node] = true;
        if(node == y)
            return count;
        for(int i = 1; i < N + 1; i++){
            if(visited[i] || map[node][i] == 0)
                continue;
            int result = DFS(i, count + 1);
            if(result != -1)
                return result;
        }
        return -1;
    }
}