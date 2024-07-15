import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] price = new int[N + 1];
        int[] dp = new int[N + 2];
        for(int i = 1; i < N + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = N; i >= 0; i--){
            if(i + time[i] > N + 1) {
                dp[i] = dp[i + 1];
            }
            else{
                dp[i] = Math.max(dp[i + 1], price[i] + dp[i + time[i]]);
            }
        }
        bw.write(String.valueOf(dp[0]));
        bw.flush();
        bw.close();


    }
}
