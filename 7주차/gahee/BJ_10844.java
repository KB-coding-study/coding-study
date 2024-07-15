import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BJ_10844 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n][10];
        Arrays.fill(dp[0], 1);
        if(n>1) {
            for(int jari = 1; jari<n; jari++) {
                dp[jari][0] = dp[jari-1][1]%1_000_000_000;;
                dp[jari][9] = dp[jari-1][8]%1_000_000_000;;
                for(int column = 1; column<9; column++) {
                    dp[jari][column] = (dp[jari-1][column-1] + dp[jari-1][column+1])%1_000_000_000;
                }
            }
        }
        long result =0;
        for(int i=1; i<10; i++) {
            result+= dp[n-1][i];
        }
        System.out.println(result%1_000_000_000);


    }

}
