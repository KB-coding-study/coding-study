import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][10];
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                if (j - 1 >= 0) {
                    dp[i][j - 1] += dp[i - 1][j];
                    dp[i][j - 1] %= 1000000000;
                }
                if (j + 1 < 10) {
                    dp[i][j + 1] += dp[i - 1][j];
                    dp[i][j + 1] %= 1000000000;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n - 1][i];
            result %= 1000000000;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.close();
    }
}