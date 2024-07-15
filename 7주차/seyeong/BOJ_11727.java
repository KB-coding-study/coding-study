package com.dp;

import java.util.Scanner;

public class BOJ_11727 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        int[] dp = new int[n + 1];
        if (n >= 1) {
            dp[1] = 1;
        }
        if (n >= 2) {
            dp[2] = 3;
        }

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);


    }
}
