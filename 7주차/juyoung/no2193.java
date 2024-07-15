import java.util.*;
import java.io.*;

public class no2193 {

    static int N;
    static Long[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dpArray = new Long[N+1];
        dpArray[0]=0L;
        dpArray[1]=1L;
        for(int i = 2 ; i <= N ; i++) {
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        }
        System.out.println(dpArray[N]);
    }
}
