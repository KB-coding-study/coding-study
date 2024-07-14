import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int next = i + arr[i][0];
            if(next < n + 2)
                dp[next] = Math.max(dp[next], dp[i] + arr[i][1]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Math.max(dp[n], dp[n + 1])));
        bw.close();
    }
}