import java.io.*;

class BJ_9461 {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4]=2; dp[5]=2;
        for(int i=6; i<=100; i++ ) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        for(int i=0; i<n; i++)
        {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
        
    }

}
