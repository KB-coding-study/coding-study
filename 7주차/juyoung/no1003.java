import java.io.*;
import java.util.*;

public class no1003 {

    static int N;
    static Long[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numArr = new Long[41];
        numArr[0] = 0L;
        numArr[1] = 1L;
        for(int i = 2 ; i < 41; i++) {
            numArr[i] = numArr[i-1] + numArr[i-2];
        }
        for (int i = 0 ; i < N ; i++) {
            int testCase = Integer.parseInt(br.readLine());
            if (testCase == 1) {
                System.out.println("0 1");
            } else if (testCase == 0) {
                System.out.println("1 0");
            } else {
            System.out.print(numArr[testCase-1]);
            System.out.println(" " + numArr[testCase]);
        }
            }
    }
}
