import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1], 0) + arr[i];
        }

        Arrays.sort(dp);
        bw.write(String.valueOf(dp[n - 1]));
        bw.flush();
        bw.close();

    }
}
