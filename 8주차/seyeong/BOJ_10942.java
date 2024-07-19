package com.dphard;

import java.util.Scanner;

public class BOJ_10942 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int length = 3; length <= N; length++) {
            for (int i = 1; i <= N - length + 1; i++) {
                int j = i + length - 1;
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            if (dp[S][E]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
