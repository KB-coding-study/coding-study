import java.util.*;
import java.io.*;

public class no1699 {

    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}

/**
 * 1 = 1
 * 2 = 1+1
 * 3 = 1+1+1
 * 4 = 2^2
 * 5 = 2^2+1
 * 6 = 2^2+1+1
 * 7 = 2^2+1+1+1
 * 8 = 2^2+2^2
 * 9 = 3^3
 * 10 = 3^3+1
 * 11 = 3^3+1+1
 * 12 = 3^3+1+1+1
 * 13 = 3^3+2^2
 * 14 = 3^3+2^2+1
 * 15 = 3^3+2^2+1+1
 * 1 2 3 1 2 3 4 2 1 2 3 4 2 3 4 1
 */
