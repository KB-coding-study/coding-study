import java.io.*;
import java.util.*;

public class no1915 {

    static int N,M;
    static long MAX = 0;
    static int[][] numArr;
    static long[][] dpMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);

        numArr = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0 ; j < M ; j++) {
                numArr[i][j] = Integer.parseInt(input[j]);
            }
        }

        dpMap = new long[N][M];
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (numArr[i][j]==1) {
                    long rectSize = checkRect(i, j);
                    dpMap[i][j] = rectSize;
                    if (MAX < rectSize) {
                        MAX = rectSize;
                    }
                }
            }
        }
        System.out.println(MAX);
    }

    private static long checkRect(int i, int j) {
        long returnNum = 1;

        if(i-1>=0 && j-1>=0) {
            if (dpMap[i-1][j-1]==0) {
                return returnNum;
            } else {
                if (dpMap[i-1][j]>=1 && dpMap[i][j-1]>=1) {
                    long num = Math.min(dpMap[i-1][j-1], dpMap[i-1][j]);
                    num = Math.min(num, dpMap[i][j-1]);
                    num = (long)Math.sqrt(num);
                    returnNum = (num+1)*(num+1);
                }
            }
        }

        return returnNum;
    }
}
