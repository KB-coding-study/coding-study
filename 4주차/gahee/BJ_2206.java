import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_2206 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        String[][] map = new String[n][m];
        int answer[][][] = new int[2][n][m];

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = strings[j];
            }
        }
        answer[0][0][0] = 1;
        answer[1][0][0] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, false));
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if(tmp.x == n-1 && tmp.y == m-1) break;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp.x;
                int ny = dy[i] + tmp.y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny].equals("1")) { //벽이라면
                        if (!tmp.wall && answer[1][nx][ny] == 0) {
                            queue.add(new Node(nx, ny, true));
                            answer[1][nx][ny] = answer[0][tmp.x][tmp.y] + 1;
                        }
                    } else { //벽이 아니라면
                        if (tmp.wall &&  answer[1][nx][ny]==0) { //이미 벽 간거
                            queue.add(new Node(nx, ny, tmp.wall));
                            answer[1][nx][ny] = answer[1][tmp.x][tmp.y] + 1;
                        } else if(!tmp.wall && answer[0][nx][ny]==0){ //벽 안간거
                            queue.add(new Node(nx, ny, tmp.wall));
                            answer[0][nx][ny] = answer[0][tmp.x][tmp.y] + 1;
                        }
                    }
                }
            }
        }

        if (answer[0][n-1][m-1]!=0 && answer[1][n-1][m-1]!=0) {
            System.out.println(Math.min(answer[0][n - 1][m - 1], answer[1][n - 1][m - 1]));
        }else if(answer[0][n-1][m-1]==0 && answer[1][n-1][m-1]==0) {
            System.out.println(-1);
        }else{
            System.out.println(Math.max(answer[0][n - 1][m - 1], answer[1][n - 1][m - 1]));
        }
    }
}

    class Node{
        int x;
        int y;
        boolean wall;


        public Node(int x, int y, boolean wall) {
            this.x = x;
            this.y =  y;
            this.wall = wall;

        }
    }
