import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class BOJ2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = parseInt(inputs[0]);
        int m = parseInt(inputs[1]);

        WallMap wallMap = new WallMap(n, m);
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                wallMap.addMap(i, j, str.charAt(j));
            }
        }

        System.out.println(wallMap.findShortRoad());
    }
}

class WallMap {

    static final int[] D_X = {1, 0, -1, 0};
    static final int[] D_Y = {0, 1, 0, -1};

    char[][] map;
    boolean[][][] visited;

    class Road {
        int x; // x 좌표
        int y; // y 좌표
        int step; // bfs 단계
        boolean destroyed; // 길에 벽이 있다면 파괴 여부

        Road(int x, int y, int step, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.destroyed = destroyed;
        }

    }

    WallMap(int n, int m) {
        map = new char[n][m];
        visited = new boolean[n][m][2];
    }

    void addMap(int x, int y, char c) {
        map[x][y] = c;
    }

    int findShortRoad() {
        Queue<Road> queue = new ArrayDeque<>(); // 큐 생성
        queue.add(new Road(0, 0, 1, false));

        while(!queue.isEmpty()) {
            Road road = queue.poll();
            if (road.x == map.length - 1 && road.y == map[0].length - 1) {
                return road.step;
            }

            for (int k = 0; k < D_X.length; k++) {
                int newX = road.x + D_X[k]; // dx dy
                int newY = road.y + D_Y[k];

                if (validRange(newX, newY)) continue;

                if (map[newX][newY] == '0') {
                    if (!road.destroyed && !visited[newX][newY][0]) {

                        queue.add(new Road(newX, newY, road.step + 1, false));
                        visited[newX][newY][0] = true; // 방문 여부 등록
                    }

                    else if (road.destroyed && !visited[newX][newY][1]) {
                        queue.add(new Road(newX, newY, road.step + 1, true));
                        visited[newX][newY][1] = true;
                    }
                }

                else if (map[newX][newY] == '1') {
                    if (!road.destroyed) {
                        queue.add(new Road(newX, newY, road.step + 1, true));
                        visited[newX][newY][1] = true;
                    }
                }
            }
        }
        return -1;
    }

    boolean validRange(int x, int y) {
        return x < 0 || y < 0 || x >= map.length || y >= map[0].length;
    }


}