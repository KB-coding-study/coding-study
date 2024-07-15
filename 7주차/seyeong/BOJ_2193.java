package com.dp;

import java.util.Scanner;

public class BOJ_2193 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] dp = new long[n + 1][2];

        if (n >= 1) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }

        if (n >= 2) {
            dp[2][0] = 1;
            dp[2][1] = 0;
        }

        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        long answer = dp[n][0] + dp[n][1];

        System.out.println(answer);

    }
}
