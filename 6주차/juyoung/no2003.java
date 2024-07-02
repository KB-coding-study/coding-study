import java.util.*;
import java.io.*;

public class no2003 {

    static int N, M;
    static int[] sumArr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);

        sumArr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cumulativeSum = 0;
        for (int i = 1 ; i < N+1 ; i++) {
            cumulativeSum += Integer.parseInt(st.nextToken());
            sumArr[i] = cumulativeSum;
        }

        int right = 0 , left = 0;
        while (left < N) {
            int num = sumArr[right] - sumArr[left];
            if (num==M) {
                if (right<N){
                    right+=1;
                } else {
                    left+=1;
                }
                answer+=1;
            }else if (num<M && right<N) {
                right+=1;
            } else {
                left+=1;
            }
        }
        System.out.println(answer);
    }
}
