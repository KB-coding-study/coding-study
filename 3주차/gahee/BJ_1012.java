
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BJ_1012 {
    static int dx[] = {1,-1, 0,0};
    static int dy[] = {0,0, 1,-1};
    static int mapx;
    static int mapy;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for(int i=0; i<time; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //init map
            mapy = Integer.parseInt(st.nextToken());
            mapx = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[mapx][mapy];
            for(int lettus=0; lettus<k; lettus++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x= Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }
            int count=0;

            // dfs
            for(int r=0; r<mapx; r++) {
                for(int c=0; c<mapy; c++) {
                    if(map[r][c]==1) {
                        dfs(r,c);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void dfs(int row, int col) {
        for(int i=0; i<4; i++) {
            int nx = dx[i]+row;
            int ny=  dy[i] +col;

            if(0<=nx && nx<mapx && 0<=ny & ny<mapy && map[nx][ny]==1) {
                map[nx][ny] = 0;
                dfs(nx,ny);
            }
        }
    }
}
