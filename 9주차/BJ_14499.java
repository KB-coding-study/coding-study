import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dice = new int[4][3];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int option = Integer.parseInt(st.nextToken());
            int change;
            switch (option) {
                case 1:
                    if (x + 1 >= M)
                        break;
                    x++;
                    change = dice[1][2];
                    dice[1][2] = dice[3][1];
                    dice[3][1] = dice[1][0];
                    dice[1][0] = dice[1][1];
                    dice[1][1] = change;
                    if (map[y][x] == 0)
                        map[y][x] = dice[1][1];
                    else {
                        dice[1][1] = map[y][x];
                        map[y][x] = 0;
                    }
                    sb.append(String.valueOf(dice[3][1])).append("\n");
                    break;
                case 2:
                    if (x - 1 < 0)
                        break;
                    x--;
                    change = dice[3][1];
                    dice[3][1] = dice[1][2];
                    dice[1][2] = dice[1][1];
                    dice[1][1] = dice[1][0];
                    dice[1][0] = change;
                    if (map[y][x] == 0)
                        map[y][x] = dice[1][1];
                    else {
                        dice[1][1] = map[y][x];
                        map[y][x] = 0;
                    }
                    sb.append(String.valueOf(dice[3][1])).append("\n");
                    break;
                case 3:
                    if (y - 1 < 0)
                        break;
                    y--;
                    change = dice[0][1];
                    dice[0][1] = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = dice[3][1];
                    dice[3][1] = change;
                    if (map[y][x] == 0)
                        map[y][x] = dice[1][1];
                    else {
                        dice[1][1] = map[y][x];
                        map[y][x] = 0;
                    }
                    sb.append(String.valueOf(dice[3][1])).append("\n");
                    break;
                case 4:
                    if (y + 1 >= N)
                        break;
                    y++;
                    change = dice[0][1];
                    dice[0][1] = dice[3][1];
                    dice[3][1] = dice[2][1];
                    dice[2][1] = dice[1][1];
                    dice[1][1] = change;
                    if (map[y][x] == 0)
                        map[y][x] = dice[1][1];
                    else {
                        dice[1][1] = map[y][x];
                        map[y][x] = 0;
                    }
                    sb.append(String.valueOf(dice[3][1])).append("\n");
                    break;

            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}