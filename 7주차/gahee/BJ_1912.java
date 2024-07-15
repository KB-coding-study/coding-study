import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] numbers = new int[n];
      String[] nums = br.readLine().split(" ");
      for(int i=0; i<nums.length; i++) {
          numbers[i] = Integer.parseInt(nums[i]);
      }
      int[] dp = new int[n+1];
      int result = Integer.MIN_VALUE ;
      for(int i=1; i<=n; i++) {
          dp[i] = Math.max(dp[i-1] + numbers[i-1], numbers[i-1]);
          result = Math.max(result, dp[i]);
      }
       System.out.println(result);
    }

}
