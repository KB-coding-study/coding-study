import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int max, sum, M, N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i =  0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        sum = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                DFS(i, j, 1);
                newCase(i, j);
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
    static void DFS(int y, int x, int count){
        visited[y][x] = true;
        sum += map[y][x];
        if(count == 4) {
            max = Math.max(max, sum);
        }
        else{
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx])
                    continue;
                DFS(ny, nx, count + 1);
            }
        }
        sum -= map[y][x];
        visited[y][x] = false;
    }

    static void newCase(int y, int x){
        int[][] dx = {{0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, 0, 1}, {0, 0, 0, -1}};
        int[][] dy = {{0, 0, -1, 0}, {0, 0, 1, 0}, {0, 1, 2, 1}, {0, 1, 2, 1}};
        for(int i = 0; i < 4; i++){
            int caseSum = 0;
            boolean check = true;
            for(int j = 0; j < 4; j++){
                int nx = x + dx[i][j];
                int ny = y + dy[i][j];
                if(nx < 0 || ny < 0 || ny >= N || nx >= M) {
                    check = false;
                    break;
                }
                caseSum += map[ny][nx];
            }
            if(check)
                max = Math.max(max, caseSum);
        }
    }
}