import java.io.*;
import java.util.*;

public class BJ_25573 {

    static int n, m;
    static int[][] map;
    static int[][] count;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       map = new int[n][m];
       count = new int[n][m];
       visited = new boolean[n][m];

       for(int i=0; i<n; i++) {
           String[] row = br.readLine().split(" ");
           for(int j=0; j<m; j++) {
               map[i][j] = Integer.parseInt(row[j]);
           }
       }

       int year = 0;
       while(true) {
           countZero();
           minusMap(map,count);
           int islandCount = countIsland();
           year++;
           if(islandCount>=2) {
               break;
           }
           if(year>0 && validateMap()==false) {
               System.out.println(0);
               System.exit(0);
           }
           count = new int[n][m];
           visited = new boolean[n][m];
       }
        System.out.println(year);

    }
    public static boolean validateMap() {
        boolean flag = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0) {
                    flag = true;
                }
            }
        }
        return flag;
    }
    public static void countZero() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]>0) {
                    int Zcount = 0;
                    for(int k=0; k<4; k++) {
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
                        if(nx>=0 && ny>=0 && nx<n && ny<m) {
                            if(map[nx][ny]<=0) {
                                Zcount++;
                            }
                        }
                    }
                    count[i][j] = Zcount;
                }
            }
        }
    }

    public static int countIsland() {
        int island = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0 && visited[i][j] == false) {
                    dfs(i, j);
                    island ++;
                }
            }
        }
        return island;
    }

    public static void minusMap(int[][] map, int [][] count) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = map[i][j] - count[i][j];
            }
        }
    }

    public static void dfs(int row, int col) {
        visited[row][col] = true;
        for(int i=0; i<4; i++) {
            int nx = dx[i] + row;
            int ny = dy[i] + col;

            if(nx>=0 && ny>=0 && nx<n && ny<m && visited[nx][ny]==false && map[nx][ny]>0) {
                dfs(nx,ny);
            }
        }
    }
}
