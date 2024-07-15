import java.util.*;
import java.io.*;

public class Main {
    static int T,N;
    static long[] dpArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        dpArr = new long[101];
        dpArr[1] = 1;
        dpArr[2] = 1;

        for (int i = 3; i < 101 ; i++) {
            dpArr[i] = dpArr[i-2] + dpArr[i-3];
        }
        for (int i = 0 ; i < T ; i++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(dpArr[N]);
        }
    }
}
