import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] ice;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        ice = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            meltIceberg();
            years++;
            visited = new boolean[N][M];
            int iceCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ice[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        iceCount++;
                    }
                }
            }
            if (iceCount > 1) {
                sb.append(years);
                break;
            }
            if (iceCount == 0) {
                sb.append(0);
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void meltIceberg() {
        int[][] nextIce = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nextIce[i][j] = ice[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ice[i][j] > 0) {
                    int waterCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && ice[nx][ny] == 0) {
                            waterCount++;
                        }
                    }
                    nextIce[i][j] = ice[i][j] > waterCount ? ice[i][j] - waterCount : 0;
                }
            }
        }
        ice = nextIce;
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && ice[nx][ny] > 0 && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}