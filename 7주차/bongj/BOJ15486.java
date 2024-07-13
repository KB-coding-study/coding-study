package bongj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15486 {
    public static void main(String[] agrs) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] benefits = new int[N+1]; //N일차 일때 받는 최대 이익
        int max = 0;

        for(int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");
            //현재일의 최대값을 이전 날짜의 최대값으로 기본값 설정
            benefits[i] = Math.max(benefits[i-1], benefits[i]);

            int time = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);

            //퇴사일 이후 예외처리
            if(i + time - 1 > N) {
                continue;
            }
            benefits[i+time-1] = Math.max(benefits[i+time-1], benefits[i-1] + price);
            //최대값 갱신
            max = Math.max(max, benefits[i+time-1]);
        }

        System.out.println(max);
    }
}
/*
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		int[][] arr =new int[n+2][2];
		int[] dp = new int[n+2];
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i][0] = t; // 기간
			arr[i][1] = p; // 금액
		}

		int max = -1;
		for(int i=1; i<=n+1; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}

			int nxt = i +arr[i][0];
			if(nxt < n+2) {
				dp[nxt] = Math.max(dp[nxt], max+arr[i][1]);
			}
		}
		System.out.println(dp[n+1]);
	}
}
 */