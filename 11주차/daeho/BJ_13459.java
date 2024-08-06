import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int N, M;
    static int redX, redY, blueX, blueY, endX, endY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R') {
                    redX = j;
                    redY = i;
                } else if (map[i][j] == 'B') {
                    blueX = j;
                    blueY = i;
                } else if (map[i][j] == 'O') {
                    endX = j;
                    endY = i;
                }
            }
        }

        int result = BFS();
        if (result != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(redX, redY, blueX, blueY, 0));
        visited[redY][redX][blueY][blueX] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.count >= 10)
                return -1;

            for (int i = 0; i < 4; i++) {
                int newRedX = current.redX;
                int newRedY = current.redY;
                int newBlueX = current.blueX;
                int newBlueY = current.blueY;

                boolean redHole = false;
                boolean blueHole = false;

                while (map[newRedY + dy[i]][newRedX + dx[i]] != '#' && map[newRedY][newRedX] != 'O') {
                    newRedX += dx[i];
                    newRedY += dy[i];
                    if (map[newRedY][newRedX] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                while (map[newBlueY + dy[i]][newBlueX + dx[i]] != '#' && map[newBlueY][newBlueX] != 'O') {
                    newBlueX += dx[i];
                    newBlueY += dy[i];
                    if (map[newBlueY][newBlueX] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                if (blueHole)
                    continue;

                if (redHole)
                    return current.count + 1;

                if (newRedX == newBlueX && newRedY == newBlueY) {
                    if (Math.abs(newRedX - current.redX) + Math.abs(newRedY - current.redY) >
                            Math.abs(newBlueX - current.blueX) + Math.abs(newBlueY - current.blueY)) {
                        newRedX -= dx[i];
                        newRedY -= dy[i];
                    } else {
                        newBlueX -= dx[i];
                        newBlueY -= dy[i];
                    }
                }

                if (!visited[newRedY][newRedX][newBlueY][newBlueX]) {
                    visited[newRedY][newRedX][newBlueY][newBlueX] = true;
                    queue.add(new Node(newRedX, newRedY, newBlueX, newBlueY, current.count + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int redX, redY, blueX, blueY, count;

        Node(int redX, int redY, int blueX, int blueY, int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }
}
