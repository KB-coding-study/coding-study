package bongj;

import java.io.*;
import java.util.Arrays;

public class BOJ22862 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int cnt = 0, res = 0;
        for (int start = 0, end = 0; start < N; ++start) {
            while (end < N) {
                if (arr[end] % 2 == 1) {
                    if (cnt >= K) {
                        break;
                    }
                    ++cnt;
                }
                ++end;
            }
            res = Math.max(res, end - start - cnt);
            if (arr[start] % 2 == 1) --cnt;
        }

        System.out.println(res);
    }
}
