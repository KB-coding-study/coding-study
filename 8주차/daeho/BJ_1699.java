import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for(int i = 1 ; i <= Math.sqrt(N); i++){
            dp[i * i] = 1;
        }

        for(int i = 1; i < N + 1; i++){
            if(dp[i] == 0){
                int k = 100000;
                for(int j = 1; j <= Math.sqrt(i); j++){
                    k = Math.min(dp[j * j] + dp[i - j * j], k);
                }
                dp[i] = k;
            }
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();


    }

}