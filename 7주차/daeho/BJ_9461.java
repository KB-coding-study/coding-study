import java.io.*;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        dp = new long[101];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = dp[4] = 2;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            for(int j = 3; j < N; j++){
                if(dp[j] == 0)
                    dp[j] = dp[j - 5] + dp[j - 1];
            }
            sb.append(dp[N - 1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
