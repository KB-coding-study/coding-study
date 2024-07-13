import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] dp = new long[100];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = dp[4] = 2;
        for (int i = 5; i < 100; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n - 1] + "\n");
            bw.flush();
        }
        bw.close();
    }
}