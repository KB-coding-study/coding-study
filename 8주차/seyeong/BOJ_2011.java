package com.dphard;

import java.util.Scanner;

public class BOJ_2011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        int n = code.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int oneDigit = code.charAt(i - 1) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (i > 1) {
                int twoDigits = (code.charAt(i - 2) - '0') * 10 + (code.charAt(i - 1) - '0');
                if (twoDigits >= 10 && twoDigits <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        System.out.println(dp[n]);
    }
}
