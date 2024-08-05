package week10.bongj;

import java.util.*;

public class BOJ14502 {
    static int N, M;
    static int[][] lab;
    static int[][] temp;
    static int mxsf = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lab = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        buildWall(0);
        System.out.println(mxsf);
    }

    public static void buildWall(int count) {
        if (count == 3) {
            virus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    buildWall(count + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    public static void virus() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = lab[i][j];
                if (temp[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = virus[0] + dx[d];
                int ny = virus[1] + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        calculateSF();
    }

    public static void calculateSF() {
        int sf = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    sf++;
                }
            }
        }
        mxsf = Math.max(mxsf, sf);
    }
}
