import java.io.*;
import java.util.*;

public class no1912 {

    static int N;
    static long MAX = Long.MIN_VALUE;
    static long[] numArr, dpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numArr = new long[N];
        dpArr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num = Long.parseLong(st.nextToken());
        numArr[0] = num;
        dpArr[0] = num;
        MAX = dpArr[0];
        for (int i = 1 ; i < N ; i++) {
            num = Long.parseLong(st.nextToken());
            numArr[i] = num;
            if (dpArr[i-1]>0) {
                dpArr[i] = dpArr[i-1]+num;
            } else {
                dpArr[i] = num;
            }
            if (dpArr[i]>MAX) {
                MAX = dpArr[i];
            }
        }
        System.out.println(MAX);
    }
}
