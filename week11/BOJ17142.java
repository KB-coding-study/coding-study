package week11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17142 {

    private static int n, m;
    private static int[][] map;
    private static boolean[] visit;

    private static int result = Integer.MAX_VALUE;
    private static int emptyCnt = 0;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static ArrayList<Virus> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    emptyCnt++;
                } else if (map[i][j] == 2) {
                    virusList.add(new Virus(i,j));
                }
            }
        }

        visit = new boolean[virusList.size()];

        dfs(0,0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    private static void dfs(int start, int count) {

        if (count == m) {


            result = Math.min(result, spreadVirus());

        } else {

            for (int i=start; i<virusList.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(i+1, count+1);
                    visit[i] = false;
                }
            }

        }

    }

    private static int spreadVirus() {

        Queue<Virus> q = new LinkedList<>();

        boolean[][] visited = new boolean[n+1][n+1];


        for (int i=0; i<virusList.size(); i++) {
            if (visit[i]) {
                q.add(new Virus(virusList.get(i).x, virusList.get(i).y, 0));
            }
        }


        int value = 0;
        int zeroCnt = 0;

        while (!q.isEmpty()) {
            Virus v = q.remove();
            int qx = v.x;
            int qy = v.y;
            int qt = v.time;

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }
                if (map[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] != 1 && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        zeroCnt++;
                        value = qt+1;
                    }
                    visited[nx][ny] = true;
                    q.add(new Virus(nx,ny,qt+1));
                }
            }
        }

        if (emptyCnt == zeroCnt) {
            return value;
        }

        return Integer.MAX_VALUE;

    }


    static class Virus {
        int x, y, time;
        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
