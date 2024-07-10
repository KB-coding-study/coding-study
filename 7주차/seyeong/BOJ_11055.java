package com.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if(n>=1){
            dp[0] = arr[0];
        }


        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[n-1]);



    }
}
