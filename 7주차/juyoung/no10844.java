import java.io.*;
import java.util.*;

public class no10844 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(countStairNumbers(N));
    }
    public static int countStairNumbers(int N) {
        long[][] dp = new long[N + 1][10];

        // 초기 조건: 길이가 1인 경우
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // DP 상태 전이
        for (int n = 2; n <= N; n++) {
            for (int d = 0; d <= 9; d++) {
                if (d > 0) {
                    dp[n][d] += dp[n-1][d-1];
                }
                if (d < 9) {
                    dp[n][d] += dp[n-1][d+1];
                }
                dp[n][d] %= 1000000000;  // 큰 수는 모듈러 연산
            }
        }

        // N자리 계단수의 총합
        int totalCount = 0;
        for (int d = 0; d <= 9; d++) {
            totalCount += dp[N][d];
            totalCount %= 1000000000;  // 큰 수는 모듈러 연산
        }

        return totalCount;
    }
}

// 1 2 3 4 5 6 7 8 9 => 9
// 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98 => 17
// 101 121 123 210 212 232 234 321 323 343 345 --- 787 789 876 878 898 987 989 => 32
// 1010 1012 1210 1212 1232 1234 2101 2121 2123 2321 2323 2343 2345 --- 6543 6545 6565 6567 6765 6767 6787 6789 7654 7656 7676 7678 7876 7878 7898 8765 8767 8787 8789 8987 8989 9876 9878 9898
