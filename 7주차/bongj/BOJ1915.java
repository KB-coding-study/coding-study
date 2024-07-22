package bongj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1915 {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N,M, max;
    private static int[][] arr, dp;
    private static void input() throws IOException {
        StringTokenizer nm = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(nm.nextToken());
        M = Integer.parseInt(nm.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for(int i = 0 ; i < N; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            for(int j = 0 ; j < M; j++) {
                arr[i][j] = Character.getNumericValue(line[j]);
                dp[i][j] = arr[i][j];
                //참고 한 부분
                if(i >= 1 && j >= 1) {
                    if(dp[i-1][j] > 0 && dp[i-1][j-1] > 0 && dp[i][j-1] > 0 && dp[i][j] > 0) {
                        int min = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                        dp[i][j] = min + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j < M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve() throws IOException {
        System.out.println(max * max);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

//다른 풀이
// public class Q1915 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[][] map = new int[N][M];
//        for(int i = 0; i < N; i++) {
//            String s = sc.next();
//            for(int j = 0; j < M; j++)
//                map[i][j] = s.charAt(j) - '0';
//        }
//
//        for(int i = 1; i < N; i++)
//            for(int j = 1; j < M; j++)
//                if(map[i][j] != 0)
//                    map[i][j] += Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1]));
//
//        int max = Arrays.stream(map)
//                .flatMapToInt(Arrays::stream)
//                .max()
//                .getAsInt();
//
//        System.out.println(max * max);
//    }
//}