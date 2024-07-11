import java.io.*;

class BJ_11053 {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[][] dp = new int[n][2];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            int currentNum = numbers[i];
            int count = 1;
            for(int j=0; j<i; j++) {
                if(currentNum > dp[j][0] && count < dp[j][1]) {
                    count = dp[j][1];
                }
            }
            dp[i][0] = currentNum;
            dp[i][1] = count+1;
            max = Math.max(max, count);
        }
       System.out.println(max);

    }

}
