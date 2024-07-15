import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        dp[0] = 1;
        if(n > 1)
            dp[1] = 3;
        for(int i = 2; i < n; i++){
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }
        bw.write(String.valueOf(dp[n - 1]));
        bw.flush();
        bw.close();
    }
}
