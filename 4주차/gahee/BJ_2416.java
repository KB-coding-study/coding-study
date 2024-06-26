import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class BJ_2416 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int islandCount = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    islandCount++;
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(min);
    }


    public static void bfs(int x, int y) {
        boolean[][] localvisited = new boolean[n][n];
        int currentIsland = map[x][y];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x,y});
        localvisited[x][y] = true;
        int count = 0;

        while(!que.isEmpty()) {
            int queSize = que.size();

            for(int i=0; i<queSize; i++) {
                int[] tmp = que.poll();

                for(int d = 0; d<4; d++) {
                    int nx = dx[d] + tmp[0];
                    int ny = dy[d] + tmp[1];

                    if(0<=nx && nx<n && 0<=ny && ny<n && !localvisited[nx][ny] && map[nx][ny]!=currentIsland) {
                        if(map[nx][ny] !=0 && map[nx][ny]!=currentIsland) {
                            min = Math.min(min, count);
                            return;
                        }

                        if(map[nx][ny]==0) {
                            que.offer(new int[] {nx,ny});
                            localvisited[nx][ny] = true;
                        }
                    }
                }
            }
            count+=1;
        }
    }


    public static void dfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = islandCount;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]  && map[nx][ny]==1) {
                dfs(nx, ny);
            }
        }
    }
}
