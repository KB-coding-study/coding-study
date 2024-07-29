import java.util.*;
import java.io.*;

public class no11399 {

    static int N;
    static Integer[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        int sum = 0;
        int next = 0;
        for (Integer num : numArr) {
            next += num;
            sum += next;
        }
        System.out.println(sum);
    }
}
