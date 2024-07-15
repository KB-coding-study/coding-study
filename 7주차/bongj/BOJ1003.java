package bongj;

import java.io.*;

public class BOJ1003 {
    static int[][] dp;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        dp = new int[41][2]; // 0~40 까지 저장 가능하도록 설정

        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            N = 0;
            K = 0;
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    static int[] fibonacci(int n) {
        if (n == 0) {
            dp[n][0] = 1;
            dp[n][1] = 0;
            return dp[n];
        } else if (n == 1) {
            dp[n][0] = 0;
            dp[n][1] = 1;
            return dp[n];
        } else if (dp[n][0] == 0 && dp[n][1] == 0) {
            int[] fib1 = fibonacci(n - 1);
            int[] fib2 = fibonacci(n - 2);
            dp[n][0] = fib1[0] + fib2[0];
            dp[n][1] = fib1[1] + fib2[1];
        }
        return dp[n];
    }
}