
import java.io.*;
import java.util.*;

public class BJ_2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1 = 1
        // 2 = 10
        // 3 = 100, 101
        // 4 = 1010, 1001, 1000,
        // 5= 10000, 10001, 10010, 10100, 10101,

        Long dp[] = new Long[n+3];
        dp[1] = 1L;
        dp[2] = 1L;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);

    }


}
