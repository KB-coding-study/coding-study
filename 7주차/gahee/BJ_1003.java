import java.io.*;

class Main {
    static int zero = 0;
    static int one = 0;
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i=2; i<41; i++ ) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        for(int i=0; i<t; i++) {
            int number = Integer.parseInt(br.readLine());

//            fibo(number);
            System.out.println(dp[number][0] + " " + dp[number][1]);
        }
//        for(int i=2; i<41; i++ ) {
//            dp[i][0] = dp[i-1][0] + dp[i-2][0];
//            dp[i][1] = dp[i-2][1] + dp[i-2][1];
//        }
    }
    public static Integer[] fibo(int n) {
        if(dp[n][0]== null || dp[n][1]==null) {
            dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
            dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
        }
        return dp[n];
    }
}