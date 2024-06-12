import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class BJ_5648 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] result = new long[n];

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
                sb.reverse();
                long num = Long.parseLong(sb.toString());
                while (num % 10 == 0) {
                    num = num % 10;
                }
                result[count] = num;
                sb.setLength(0);
                count++;
            }
            if (count > n - 1) {
                break;
            }
            st = new StringTokenizer(br.readLine());
        }
        Arrays.sort(result);
        for (long i : result) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
