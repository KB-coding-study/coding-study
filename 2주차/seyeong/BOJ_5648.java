package com.ohgiraffers;

import java.util.*;

public class BOJ_5648 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];

        for (int k = 0; k < n; k++) {
            String s = sc.next();
            String q = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                q += s.charAt(i);
            }
            arr[k] = Long.parseLong(q);
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
