import java.io.*;

class BJ11055 {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int [] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
       long[][] dp = new long [n][2];
       long result=Integer.MIN_VALUE;
       for(int i=0; i<n; i++) {
           int current = num[i];
           long currentSum = 0;
           dp[i][0] = current;
           for(int j=0; j<i; j++) {
               if(current > dp[j][0] && currentSum < dp[j][1]) {
                   currentSum = dp[j][1];
               }
           }
           dp[i][1] = currentSum+current;
           result = Math.max(result, dp[i][1]);
       }
       System.out.println(result);
    }

}
