import java.util.*;
import java.io.*;

public class no14501 {

    static int N;
    static int[] T, P;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        dp = new long[N+1];

        for (int i = 1 ; i < N+1 ; i++) {
            String str = br.readLine();
            T[i] = Integer.parseInt(str.split(" ")[0]);
            P[i] = Integer.parseInt(str.split(" ")[1]);
        }
        for (int i = 1 ; i < N+1 ; i++) {
            if (dp[i]<dp[i-1]) {
                dp[i] = dp[i-1];
            }
            if (i+T[i]-1<=N) {
                if (dp[i + T[i] - 1] < dp[i - 1] + P[i]) {
                    dp[i + T[i] - 1] = dp[i - 1] + P[i];
                }
            }
        }
        System.out.println(dp[N]);
    }
}

// 0 0 10 30 30 45 45 => 뒤에 전부 바꿔가는 방법 => x
// 0 0 0 10 0 0 20 0
/*** 1. 전 날에 했던 거 현재 날짜에 삽입
 *   2. 지금날짜 + 상담 필요 날짜에 전 날의 금액 + 이번 상담 금액을 넣음. 크면 넣음.
 */
