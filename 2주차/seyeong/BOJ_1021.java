package com.ohgiraffers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int tm = 0;

        for (int i = 0; i < m; i++) {
            int target = arr[i];
            int cnt = 0;

            for (Integer num : dq) {
                if (num == target) {
                    break;
                }
                cnt++;
            }

            int halfSize = dq.size() / 2;
            if (cnt <= halfSize) {
                for (int j = 0; j < cnt; j++) {
                    dq.offerLast(dq.pollFirst());
                    tm++;
                }
            } else {
                for (int j = 0; j < dq.size() - cnt; j++) {
                    dq.offerFirst(dq.pollLast());
                    tm++;
                }
            }

            dq.pollFirst();
        }

        System.out.println(tm);
    }
}
