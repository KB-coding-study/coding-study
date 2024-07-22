import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] dp = new int[s.length()];

        if(s.charAt(0) != '0'){
            dp[0] = 1;
            if(s.length() > 1 && s.charAt(1) != '0')
                dp[1] = 1;
        }

        int temp = 0;
        if (s.length() > 1) {
            temp = Integer.parseInt(s.substring(0, 2));
            if (s.charAt(0) != '0' && temp >= 1 && temp <= 26)
                dp[1]++;
        }

        for (int i = 2; i < s.length(); i++) {
            if(s.charAt(i) != '0')
                dp[i] = dp[i - 1];

            temp = Integer.parseInt(s.substring(i - 1, i + 1));
            if (s.charAt(i - 1) != '0' && temp >= 1 && temp <= 26)
                dp[i] += dp[i - 2];
            dp[i] %= 1000000;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(dp[dp.length - 1]));
        bw.close();
    }
}