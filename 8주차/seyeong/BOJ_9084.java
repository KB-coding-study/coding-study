package com.dphard;

import java.util.Scanner;

public class BOJ_9084 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] answer = new int[T];

        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            int cost = sc.nextInt();
            int[] dp = new int[cost+1];
            dp[0] = 1;
//            System.out.println(arr[0]);

            for(int j : arr){
                for(int k = j; k < dp.length; k++) {
                    dp[k] += dp[k-j];
                }
            }
//            System.out.println(dp[3]);
            answer[i] = dp[cost];


        }

        for(int i : answer){
            System.out.println(i);
        }
    }
}
