import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] tomato;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        queue.add(new Node(k, j, i));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int result = bfs(queue);

        if (check()) {
            bw.write(String.valueOf(result));
        }
        else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }

    static int bfs(Queue<Node> queue) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            for (int i = 0; i < size; i++) {
                Node next = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = next.x + dx[j];
                    int ny = next.y + dy[j];
                    int nz = next.z + dz[j];
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H)
                        continue;
                    if(visited[nz][ny][nx] || tomato[nz][ny][nx] != 0)
                        continue;
                    visited[nz][ny][nx] = true;
                    tomato[nz][ny][nx] = 1;
                    queue.add(new Node(nx, ny, nz));
                }
            }
        }
        return days;
    }

    static boolean check() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomato[h][n][m] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
