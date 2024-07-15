import java.io.*;

class BJ_15486 {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+2];
        int[] d = new int[n+2];
        long[] dp = new long[n+2];
        for(int i=1; i<=n; i++) {
            String [] info = br.readLine().split(" ");
            d[i] = Integer.parseInt(info[0]);
            p[i] = Integer.parseInt(info[1]);
        }
        for(int i=1; i<=n+1; i++) {
            int day = d[i] + i;
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (day <= n + 1) {
                dp[day] = Math.max(dp[day], Math.max(dp[i - 1], dp[i] + p[i]));
            }
        }
       System.out.println(dp[n+1]);
    }
}
