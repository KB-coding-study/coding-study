import java.io.*;
import java.util.*;

public class no14502 {

    static int N,M;
    static int[][] map;
    static Queue<Virus> viruses;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);
        map = new int[N][M];

        viruses = new LinkedList<>();

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        buildWall(0);
        spreadVirus();
        System.out.println(count);
    }

    private static void buildWall(int wallCount){
        if (wallCount==3) {
            spreadVirus();
            return;
        }
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if(map[i][j]==0) {
                    map[i][j] = 1;
                    buildWall(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        int[][] copyMap = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            copyMap[i] = map[i].clone();
        }
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ;j++) {
                if(copyMap[i][j] == 2) {
                    viruses.add(new Virus(i, j));
                }
            }
        }

        while(!viruses.isEmpty()) {
            Virus virus = viruses.poll();
            int y = virus.y;
            int x = virus.x;

            for (int i = 0 ; i < 4; i++) {
                if (y+dy[i]>=0 && y+dy[i]<N && x+dx[i]>=0 && x+dx[i]<M) {
                    if (copyMap[y+dy[i]][x+dx[i]]==0) {
                        copyMap[y+dy[i]][x+dx[i]] = 2;
                        viruses.add(new Virus(y+dy[i], x+dx[i]));
                    }
                }
            }
        }
        int safe = countSafe(copyMap);
        if (count<safe) {
            count = safe;
        }
    }

    private static int countSafe(int[][] map) {
        return (int) Arrays.stream(map)
                .flatMapToInt(Arrays::stream)
                .filter(cell->cell == 0)
                .count();
    }
}
class Virus{
    int y, x;
    public Virus(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
