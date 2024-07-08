package com.dp;

import java.util.Scanner;

public class BOJ_1003 {

    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();


            dp = new int[41][2];


            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;


            for(int j = 2; j<dp.length; j++){
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }


            System.out.println(dp[N][0] + " " + dp[N][1]);


        }
    }


}
