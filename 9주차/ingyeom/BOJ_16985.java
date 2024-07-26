import java.io.*;
import java.util.*;

public class Main {
    static int[][][] maze = new int[5][5][5], mazeCopy = new int[5][5][5];
    static int arr[] = new int[5], floor[] = new int[5];
    static boolean check[] = new boolean[5];
    static int result = Integer.MAX_VALUE;
    static int[][][] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int l = 0; l < 5; l++) {
                    maze[i][j][l] = Integer.parseInt(st.nextToken());
                }
            }
        }

        floorCheck(0);
        System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
    }

    static void floorCheck(int k) {
        if(k == 5){
            backTracking(0);
            return;
        }

        for(int i = 0; i < 5; i++) {
            if(!check[i]) {
                check[i] = true;
                floor[k] = i;
                floorCheck(k + 1);
                check[i] = false;
            }
        }
    }

    static void backTracking(int k) {
        if(k == 5) {
            for(int i = 0; i < 5; i++) {
                rotation();
            }

            if(mazeCopy[0][0][0] == 1 && mazeCopy[4][4][4] == 1) {
                bfs();

                if(count[4][4][4] != 0) {
                    result = Math.min(result, count[4][4][4]);
                    if(result == 12) { // 최단거리 출력
                        System.out.println(12);
                        System.exit(0);
                    }
                }

            }
            return;
        }

        for(int i = 1; i < 5; i++) {
            arr[k] = i;
            backTracking(k + 1);
        }
    }

    static void rotation() {
        for(int i = 0; i < 5; i++) {
            int idx = floor[i];
            int rotationNum = arr[i];
            for(int j = 0; j < 5; j++) {
                for(int l = 0; l < 5; l++) {
                    if(rotationNum == 1) {
                        mazeCopy[idx][j][l] = maze[i][j][l];
                    }
                    if(rotationNum == 2) {
                        mazeCopy[idx][l][4 - j] = maze[i][j][l];
                    }
                    if(rotationNum == 3) {
                        mazeCopy[idx][4 - j][4 - l] = maze[i][j][l];
                    }
                    if(rotationNum == 4) {
                        mazeCopy[idx][4 - l][j] = maze[i][j][l];
                    }
                }
            }
        }

    }

    static void bfs() {
        int[][] dist = {{-1, 0, 0}, {1, 0, 0}, {0, 0, -1}, {0, 0, 1}, {0, 1, 0}, {0, -1, 0}};
        Queue<Pair> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[5][5][5];
        count = new int[5][5][5];
        visit[0][0][0] = true;
        queue.add(new Pair(0, 0, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for(int i = 0; i < 6; i++) {
                int nz = cur.z + dist[i][0];
                int nx = cur.x + dist[i][1];
                int ny = cur.y + dist[i][2];
                if(nz < 0 || nz >= 5 || nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(visit[nz][nx][ny] || mazeCopy[nz][nx][ny] != 1) continue;
                count[nz][nx][ny] = count[cur.z][cur.x][cur.y] + 1;
                if(nz == 4 && nx == 4 && ny == 4) {
                    return;
                }
                visit[nz][nx][ny] = true;
                queue.add(new Pair(nz, nx, ny));
            }
        }
    }

    public static class Pair {
        int x;
        int y;
        int z;

        public Pair( int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}