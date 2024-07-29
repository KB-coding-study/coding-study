import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[6];
        int[][] d = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            int move = Integer.parseInt(st.nextToken());
            int nx = x + d[move - 1][0];
            int ny = y + d[move - 1][1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;

            x = nx;
            y = ny;
            if (move == 1) {
                int temp = dice[0];
                dice[0] = dice[1];
                dice[1] = temp;

                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;

                temp = dice[2];
                dice[2] = dice[5];
                dice[5] = temp;
            }
            else if(move == 2) {
                int temp = dice[0];
                dice[0] = dice[2];
                dice[2] = temp;

                temp = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;

                temp = dice[2];
                dice[2] = dice[5];
                dice[5] = temp;
            }
            else if(move == 3) {
                int temp = dice[0];
                dice[0] = dice[3];
                dice[3] = temp;

                temp = dice[3];
                dice[3] = dice[5];
                dice[5] = temp;

                temp = dice[4];
                dice[4] = dice[5];
                dice[5] = temp;
            }
            else if(move == 4) {
                int temp = dice[0];
                dice[0] = dice[4];
                dice[4] = temp;

                temp = dice[3];
                dice[3] = dice[4];
                dice[4] = temp;

                temp = dice[4];
                dice[4] = dice[5];
                dice[5] = temp;
            }

            if (arr[x][y] == 0) {
                arr[x][y] = dice[5];
            }
            else {
                dice[5] = arr[x][y];
                arr[x][y] = 0;
            }

            sb.append(dice[0]).append("\n");
        }

        System.out.print(sb);
    }
}