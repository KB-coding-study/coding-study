import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[][] d = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int result = 100;

    public static int[] move(int r, int c, int direct, int r2, int c2) {
        int nr = r;
        int nc = c;

        while (true) {
            nr += d[direct][0];
            nc += d[direct][1];

            if((nr == r2 && nc == c2) || arr[nr][nc] == '#')
                return new int[]{nr - d[direct][0], nc - d[direct][1]};

            if(arr[nr][nc] == 'O')
                return new int[]{0, 0};
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bbr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bbr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        int[] red = new int[2];
        int[] blue = new int[2];

        for (int i = 0; i < n; i++) {
            String temp = bbr.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j);

                if(arr[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                    arr[i][j] = '.';
                }
                else if(arr[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                    arr[i][j] = '.';
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{red[0], red[1], blue[0], blue[1], 0, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int rr = cur[0];
            int rc = cur[1];
            int br = cur[2];
            int bc = cur[3];
            int count = cur[4];
            int direct = cur[5];

            if (count >= 10)
                continue;

            for (int i = 1; i <= 4; i++) {
                if(i == direct)
                    continue;

                int[] t1 = move(br, bc, i, rr, rc);
                if(t1[0] == 0 && t1[1] == 0)
                    continue;

                int[] t2 = move(rr, rc, i, t1[0], t1[1]);

                int[] t3 = move(t1[0], t1[1], i, t2[0], t2[1]);
                if(t3[0] == 0 && t3[1] == 0)
                    continue;

                if (t2[0] == 0 && t2[1] == 0) {
                    result = Math.min(result, count + 1);
                    continue;
                }

                queue.add(new int[]{t2[0], t2[1], t3[0], t3[1], count + 1, i});
            }
        }

        System.out.println(result == 100 ? -1 : result);
    }
}