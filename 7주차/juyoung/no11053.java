import java.util.*;
import java.io.*;

public class no11053 {

    static int N, MAX = 1;
    static int[] numArr, dpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        numArr = new int[N];
        dpArr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            numArr[i] = num;
            dpArr[i] = 1;
            for (int j = i ; j>=0 ; j--) {
                if (numArr[j]<numArr[i] && dpArr[j]>=dpArr[i]) {
                    dpArr[i] = dpArr[j]+1;
                    if (MAX<dpArr[i]) {
                        MAX = dpArr[i];
                    }
                }
            }
        }
        System.out.println(MAX);
    }
}
