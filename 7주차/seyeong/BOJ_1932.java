package com.dp;

import java.util.Scanner;

public class BOJ_1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else {
                   if(dp[i-1][j] >= dp[i-1][j-1]){
                       dp[i][j] = dp[i-1][j] + arr[i][j];
                   }else{
                       dp[i][j] = dp[i-1][j-1] + arr[i][j];
                   }
                }

            }
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]+", ");
//            }
//            System.out.println();
//        }
        int max = 0;


        for(int i = 0; i < n; i++) {
            if(dp[n-1][i] > max){
                max = dp[n-1][i];
            }
        }

        System.out.println(max);


    }
}
