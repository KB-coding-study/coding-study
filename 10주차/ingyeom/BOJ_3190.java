import java.io.*;
import java.util.*;

public class Main {
    static int[][] b = new int[102][102];
    static int[][] d = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static Deque<int[]> snake = new ArrayDeque<>();
    static int direct = 0;
    static int result = 0;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                b[i][j] = 1;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            b[r][c] = 2;
        }

        snake.add(new int[]{1, 1});
        b[1][1] = 3;
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char temp = st.nextToken().charAt(0);

            int c = 1;
            if (temp == 'D')
                c = 3;

            for (int j = result; !check && j < x; j++)
                go();

            if (!check)
                direct = (direct + c) % 4;
        }

        while(!check)
            go();
        System.out.println(result);
    }

    public static void go() {
        result++;

        int nr = snake.peek()[0] + d[direct][0];
        int nc = snake.peek()[1] + d[direct][1];

        if (b[nr][nc] == 0 || b[nr][nc] == 3) {     // 벽 or 뱀
            check = true;
            return;
        }

        if (b[nr][nc] == 1) {       // 사과가 아님
            int tailr = snake.peekLast()[0];
            int tailc = snake.peekLast()[1];
            b[tailr][tailc] = 1;
            snake.pollLast();
        }
        snake.addFirst(new int[]{nr, nc});
        b[nr][nc] = 3;
    }

}