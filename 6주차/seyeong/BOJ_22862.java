package com.tp;

import java.util.Scanner;

public class BOJ_22862 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0;
        int rt = 0;
        int oddCount = 0;
        int maxLength = 0;

        while (rt < N) {
            if (arr[rt] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > K) {
                if (arr[lt] % 2 != 0) {
                    oddCount--;
                }
                lt++;
            }

            maxLength = Math.max(maxLength, rt - lt + 1 - oddCount);
            rt++;
        }

        System.out.println(maxLength);
    }
}
