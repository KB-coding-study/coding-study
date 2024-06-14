import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_7562 {
    static int n;
    static int T;
    static int[] dx = {2,2,1,1,-2,-2,-1,-1};
    static int[] dy = {1,-1,-2,2,1,-1,-2,2};
    static int[][] map;
    static Queue<int[]> que;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            int[][] visitied = new int[n][n];
            que = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int lastRow = Integer.parseInt(st.nextToken());
            int lastCol = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startRow, startCol, lastRow, lastCol,visitied));
        }
    }


    static int bfs(int startRow, int startCol, int lastRow, int lastCol, int[][]visitied) {
        visitied[startRow][startCol] = 1;
        que.offer(new int[]{startRow, startCol});
        count=0;
        while(!que.isEmpty()) {
           int size = que.size();
           count++;
           for(int i=0; i<size; i++ ) {
               int[] poll = que.poll();
               int x = poll[0];
               int y = poll[1];
               for(int a=0; a<8; a++) {
                   int nx = dx[a] + x;
                   int ny = dy[a] + y;
                   if(0<=nx && nx<n && 0<=ny && ny<n && visitied[nx][ny]==0) {
                       if(nx == lastRow && ny == lastCol) {
                           return count;
                       }
                       visitied[nx][ny] = 1;
                       que.offer(new int[]{nx,ny});
                   }
               }
           }
        }
        return 0;
    }
}
