package bongj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
////메모지에이션과 재귀를 씀
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//
//public class Main {
//    private static int[] dp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bf.readLine());
//        dp = new int[n + 1];
//
//        // dp 배열 초기화
//        for (int i = 0; i <= n; i++) {
//            dp[i] = -1;
//        }
//
//        System.out.println(tile(n));
//    }
//
//    private static int tile(int n) {
//        // base case
//        if (n == 0) return 1;
//        if (n == 1) return 1;
//
//        // 이미 계산한 경우
//        if (dp[n] != -1) return dp[n];
//
//        // 계산하지 않은 경우
//        dp[n] = (tile(n - 1) + tile(n - 2) * 2) % 10007;
//        return dp[n];
//    }
//}
