package com.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13335 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }

        Queue<Integer> dari = new LinkedList<>();
        int sum = 0;
        int answer = 0;

        for (int i = 0; i < w; i++) {
            dari.offer(0);
        }

        while (!q.isEmpty() || sum > 0) {
            answer++;

            sum -= dari.poll();

            if (!q.isEmpty() && sum + q.peek() <= L) {
                int nextTruck = q.poll();
                dari.offer(nextTruck);
                sum += nextTruck;
            } else {
                dari.offer(0);
            }
        }

        System.out.println(answer);
    }
}
