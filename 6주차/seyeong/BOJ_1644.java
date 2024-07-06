package com.tp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ_1644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if (N < 2) {
            System.out.println(0);
            return;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int sum = 0;
        int answer = 0;

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                dq.add(i);
                sum += i;
                while (sum > N) {
                    sum -= dq.poll();
                }
                if (sum == N) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isPrime(int y) {
        if (y < 2) return false;
        for (int i = 2; i <= Math.sqrt(y); i++) {
            if (y % i == 0) {
                return false;
            }
        }
        return true;
    }
}
