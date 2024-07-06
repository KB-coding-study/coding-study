package com.tp;

import java.util.Scanner;

public class BOJ_20922 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findLongestSubarray(N, K, arr));
    }

    public static int findLongestSubarray(int N, int K, int[] arr) {
        int[] count = new int[100001];
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < N) {
            count[arr[right]]++;

            while (count[arr[right]] > K) {
                count[arr[left]]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
