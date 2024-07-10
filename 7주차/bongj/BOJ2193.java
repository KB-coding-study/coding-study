package bongj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);

    }
    //생각하지 못한 부분 ,,n=1일때 =0일때를 계산해보고 점화식을 세웠다면 쉽게 푸는 문제였으나
    //문제의 요구사항 처리를 다하다보니 못풀었다
}
