import java.io.*;
import java.util.*;

public class no11055 {

    static int N;
    static long MAX = Long.MIN_VALUE;
    static long[] numArr;
    static long[] dpArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new long[N];
        dpArr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            long num = Long.parseLong(st.nextToken());
            numArr[i] = num;
            dpArr[i] = num;
            for (int j = i-1 ; j > -1 ; j--) {
                if (numArr[j]<numArr[i] && dpArr[j]+numArr[i]>dpArr[i]) {
                    dpArr[i] = dpArr[j]+numArr[i];
                }
            }
            if(MAX<dpArr[i]) {
                MAX = dpArr[i];
            }
        }
        System.out.println(MAX);
    }
}
