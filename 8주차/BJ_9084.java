import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int j = 0 ; j  < N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][M + 1];
            for(int j = 0; j < N + 1; j++){
                dp[j][0] = 1;
            }
            for(int j = 1; j < N + 1; j++){
                for(int k = 1; k < M + 1; k++){
                    if(k < arr[j - 1])
                        dp[j][k] = dp[j - 1][k];
                    else {
                        dp[j][k] = dp[j][k - arr[j - 1]] + dp[j - 1][k];
                    }
                }
            }
            sb.append(dp[N][M]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}