import java.io.*;
import java.util.*;

public class no1644 {

    static int N, maxIndex = -1, answer = 0;
    static int[] isPrimeNums;
    static int INF = 2_000_000;
    static List<Integer> sumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isPrimeNums = new int[INF+1];
        sumList = new LinkedList<>();
        int cumulativeSum = 0;
        for (int i = 2 ; i < INF ; i++) {
            if (isPrimeNums[i]==0) {
                cumulativeSum += i;
                if (i<=N) {
                    maxIndex += 1;
                }
                sumList.add(cumulativeSum);
                for (int j = 2; j < INF; j++) {
                    if (i * j > INF) {
                        break;
                    }
                    isPrimeNums[i*j]=1;
                }
            }
        }

        int right = 0, left = 0;
        while(left<maxIndex) {
            int value = sumList.get(right) - sumList.get(left);
            if(value == N || sumList.get(right)==N) {
                answer += 1;
                right += 1;
            } else if (value < N) {
                right += 1;
            } else if (value > N) {
                left += 1;
            }
        }
        System.out.println(answer);
    }
}
