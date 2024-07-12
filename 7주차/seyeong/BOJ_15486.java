package com.dp;

import java.util.Scanner;

public class BOJ_14501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            if (i + t[i] <= n + 1) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

        }

        System.out.println(dp[n+1]);


    }
}
