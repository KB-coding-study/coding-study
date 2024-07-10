package bongj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] inputs = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = inputs[1];
        for (int i = 1; i <= N; i++) {
            dp[i] = inputs[i];
            for (int j = 1; j < i; j++) {
                if (inputs[i] > inputs[j]) {
                    dp[i] = Math.max(dp[j] + inputs[i], dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);

    }
}
