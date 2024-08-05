import java.io.*;
import java.util.*;

public class Main {
    static int N, M, emptyCount, startCount, answer;
    static int[][] map, empty, start;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[N][M];

        emptyCount = 0;
        startCount = 0;
        empty = new int[64][2];
        start = new int[64][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    empty[emptyCount][0] = i;
                    empty[emptyCount][1] = j;
                    emptyCount++;
                }
                else if(map[i][j] == 2){
                    start[startCount][0] = i;
                    start[startCount][1] = j;
                    startCount++;
                }
            }
        }
        for(int i = 0; i < emptyCount - 2; i++){
            for(int j = i + 1; j < emptyCount - 1; j++){
                for(int k = j + 1; k < emptyCount; k++){
                    map[empty[i][0]][empty[i][1]] = 1;
                    map[empty[j][0]][empty[j][1]] = 1;
                    map[empty[k][0]][empty[k][1]] = 1;
                    BFS(start);
                    map[empty[i][0]][empty[i][1]] = 0;
                    map[empty[j][0]][empty[j][1]] = 0;
                    map[empty[k][0]][empty[k][1]] = 0;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static void BFS(int[][] arr){
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[N][M];
        int result = 0;
        for(int i = 0; i < startCount; i++){
            queue.add(new Node(start[i][0], start[i][1]));
            visited[start[i][0]][start[i][1]] = true;
        }
        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 1)
                    continue;
                queue.add(new Node(nx, ny));
                result++;
                visited[nx][ny] = true;
            }
        }
        answer = Math.max(emptyCount - 3 - result, answer);
    }
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
