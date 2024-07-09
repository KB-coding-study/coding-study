import java.util.*;
import java.io.*;

public class no11727 {

    static int N;
    static int[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dpArray = new int[N+1];
        dpArray[1] = 1;

        for (int i = 2 ; i <= N ; i++) {
            if (i%2==0) {
                dpArray[i] = (dpArray[i-1]*2+1)%10007;
            } else {
                dpArray[i] = (dpArray[i-1]*2-1)%10007;
            }
        }
        System.out.println(dpArray[N]);
    }
}
