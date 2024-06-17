import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) == '1' ? 1 : 0;
            }
        }

        int result = BFS();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (map[nx][ny] == 0) {
                    // 벽을 부순다는 조건을 어떻게 적용해야 할지 해결 방법을 찾지 못해서 여러 참조를 통해서 해결했습니다.
                    // 벽을 부순적이 있는지를 나타내는 boolean 값과 삼중배열을 통해서 조건을 잘 나누면 해결 가능하네요. 이걸 어떻게 혼자서 풀죠.. ㅜ
                    if (!current.wall && !visited[nx][ny][0]) {  // 벽을 부수지 않았고, 해당 위치를 방문하지 않은 경우에
                        queue.add(new Node(nx, ny, current.dist + 1, false)); // 새로운 위치 큐에 추가 (false 를 통해 벽을 부수지 않은 상태도 전달)
                        visited[nx][ny][0] = true; // 벽을 부수지 않은 상태는 0을, 부순 상태는 1을 이용하는 삼중배열을 이용해서 두가지의 경우 모두 따질 수 있음
                    }
                    else if (current.wall && !visited[nx][ny][1]) { // 벽을 부순 상태이고, 해당 위치를 방문하지 않은 경우
                        queue.add(new Node(nx, ny, current.dist + 1, true));
                        visited[nx][ny][1] = true; // 벽을 부순 상태니까 1을 이용
                    }
                }
                else if (map[nx][ny] == 1 && !current.wall) { // 벽이지만 벽을 부순적이 없는 경우
                    queue.add(new Node(nx, ny, current.dist + 1, true)); // true로 바꿔서 boolean 전달
                    visited[nx][ny][1] = true;
                }
            }
        }

        return -1;
    }

    static class Node {
        int x, y, dist;
        boolean wall;

        public Node(int x, int y, int dist, boolean wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }
}
