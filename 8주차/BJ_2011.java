import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String key = "0";
        key += br.readLine();
        int[] dp = new int[key.length() + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < key.length() + 1; i++){
            int case1 = Integer.valueOf(key.substring(i - 1, i));
            int case2 = Integer.valueOf(key.substring(i - 2, i));
            if(case1 == 0 && (case2 < 0 || case2 > 26))
                break;

            if(case1 != 0){
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }
            else
                dp[i - 1] = 0;
            if(case2 >= 0 && case2 <= 26)
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            else
                dp[i - 2] = 0;
        }
        bw.write(String.valueOf(dp[key.length()]));
        bw.flush();
        bw.close();
    }
}