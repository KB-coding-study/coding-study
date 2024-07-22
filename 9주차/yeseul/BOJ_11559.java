import java.util.*;

public class BOJ_11559 {
    static char[][] field;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static ArrayList<Node> list;
    static int n = 12, m = 6;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        field = new char[n][m];
        for(int i = 0; i < n; i++) {
            String field = scan.nextLine();
            for(int j = 0; j < m; j++) {
                BOJ_11559.field[i][j] = field.charAt(j);
            }
        }

        int count = 0;

        while(true) {
            boolean isFinished = true;
            visited = new boolean[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(field[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(field[i][j], i, j);

                        if(list.size() >= 4) {
                            isFinished = false;
                            for(int k = 0; k < list.size(); k++) {
                                field[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if(isFinished) break;
            fallPuyos();
            count++;
        }
        System.out.println(count);
    }

    public static void fallPuyos() {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (field[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (field[k][i] != '.') {
                            field[j][i] = field[k][i];
                            field[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(char c, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list.add(new Node(x, y));
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false && field[nx][ny] == c) {
                    visited[nx][ny] = true;
                    list.add(new Node(nx, ny));
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
