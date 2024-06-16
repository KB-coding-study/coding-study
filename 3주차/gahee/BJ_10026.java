import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BJ_10026 {
    static int n;
    static char[][] map;
    static char[][] yak;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int count=0;
    static Queue<List<Integer>> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        yak = new char[n][n];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                char c = line.charAt(j);
                if(c=='G') {
                   yak[i][j] = 'R';
                   continue;
                }
                map[i][j] = c;
                yak[i][j] = c;
            }
        }
        int yakCount=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] !='0') {
                    char start = map[i][j];
                    map[i][j] = '0';
                    count++;
                    dfs(i,j, start, map);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(yak[i][j] !='0') {
                    char start = yak[i][j];
                    yak[i][j] = '0';
                    yakCount++;
                    dfs(i,j, start, yak);
                }
            }
        }
        System.out.println(count + " " + yakCount);
    }

    public static void dfs(int row, int col, char point, char[][] MAP) {
        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + row;
            int ny = dy[k] + col;
            if (0 <= nx && nx < n && 0 <= ny && ny < n && MAP[nx][ny] == point) {
                MAP[nx][ny] = '0';
                dfs(nx, ny, point, MAP);
            }
        }
    }

}

