package bongj;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {

    static char[] str1;
    static char[] str2;

    static int[][] dp;

    static int LCS(int[][] dp) {

        for (int i = 1; i<=str1.length; i++) {
            for (int j = 1; j<=str2.length; j++) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[str1.length][str2.length];
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        str1 = st1.nextToken().toCharArray();
        str2 = st2.nextToken().toCharArray();

        dp = new int[str1.length+1][str2.length+1];

        System.out.println(LCS(dp));
    }
}