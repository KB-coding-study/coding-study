import java.util.*;
import java.io.*;

public class no7569 {

    static int[][][] box;
    static Queue<LocationOfTomato> locationOfTomatoes;
    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {0,0,0,0,1,-1};
    static int[] dz = {1,-1,0,0,0,0};
    static int day = 0;
    static int M,N,H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        locationOfTomatoes = new LinkedList<LocationOfTomato>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[i][j][k] = tomato;
                    if (tomato == 1) {
                        locationOfTomatoes.offer(new LocationOfTomato(i, j, k));
                    }
                }
            }
        }

        bfs(locationOfTomatoes);
        if (isEveryTomatoesBoiled(box)) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }
    public static void bfs(Queue<LocationOfTomato> locationOfTomatoes) {
        if (locationOfTomatoes.isEmpty()) {
            day = -1;
        }

        int sizeOfQueue = locationOfTomatoes.size();
        while(sizeOfQueue!=0) {
            LocationOfTomato locationOfTomato = locationOfTomatoes.poll();
            int z = locationOfTomato.z;
            int y = locationOfTomato.y;
            int x = locationOfTomato.x;

            for (int i = 0 ; i < 6; i++) {
                int nextZ = z+dz[i];
                int nextY = y+dy[i];
                int nextX = x+dx[i];
                if (nextZ>=0&&nextZ<H && nextY>=0&&nextY<N && nextX>=0&&nextX<M) {
                    if(box[nextZ][nextY][nextX]==0) {
                        box[nextZ][nextY][nextX] = 1;
                        locationOfTomatoes.offer(new LocationOfTomato(nextZ, nextY, nextX));
                    }
                }
            }
            sizeOfQueue-=1;
            if (sizeOfQueue==0) {
                sizeOfQueue = locationOfTomatoes.size();
                if (sizeOfQueue!=0) {
                    day+=1;
                }
            }
        }
    }

    public static boolean isEveryTomatoesBoiled(int[][][] box) {
        boolean EveryTomatoesBoiled = true;
        for (int z = 0 ; z < H ; z++) {
            for (int y = 0 ; y < N ; y++) {
                for (int x = 0 ; x < M ; x++) {
                    if (box[z][y][x] == 0) {
                        EveryTomatoesBoiled = false;
                        break;
                    }
                }
            }
        }
        return EveryTomatoesBoiled;
    }

    static class LocationOfTomato {
        int z,y,x;
        private LocationOfTomato(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
