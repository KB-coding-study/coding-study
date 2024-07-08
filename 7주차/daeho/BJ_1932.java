import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int max = 0;

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n + 2];
        arr[0][0] = Integer.parseInt(br.readLine());
        dp[0][1] = arr[0][0];

        for(int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < i + 1; j++){
                dp[i][j + 1] = Math.max(dp[i - 1][j], dp[i - 1][j + 1]) + arr[i][j];
            }
        }

        for(int i = 1; i <= n; i++){
            max = Math.max(dp[n - 1][i], max);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();



    }
}
