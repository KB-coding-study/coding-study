import java.io.*;

public class Main {
    static int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        if (ch[0] == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[ch.length+1];
        dp[0] = dp[1] = 1;


        for (int i = 2; i <= ch.length; i++) {
            if (ch[i-1] != '0') {
                dp[i] += dp[i-1] % MOD;
            }

            int temp = ((ch[i-2] - '0') * 10) + ch[i-1] - '0';
            if (temp >= 10 && temp <= 26) {
                dp[i] += dp[i-2] % MOD;
            }
        }
        System.out.println(dp[ch.length] % MOD);
    }
}