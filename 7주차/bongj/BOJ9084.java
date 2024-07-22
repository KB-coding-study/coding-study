package bongj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9084 {

    public static int T, N, M;

    public static StringBuilder sb = new StringBuilder();
    public static int answer = 0;
    public static int[] c;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            c = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            dp = new int[M+1];

            dp[0] = 1;

            for(int i=0;i<N;i++) {
                for(int j = c[i]; j<M+1; j++) {
                    dp[j] = dp[j] + dp[j - c[i]];
                }
            }
            System.out.println(dp[M]);

        }

    }


}