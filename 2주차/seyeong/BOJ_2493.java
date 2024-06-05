package com.ohgiraffers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];

        Stack<Integer> st = new Stack<>();
        Stack<Integer> as = new Stack<>();

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(input[i]);

            while (!st.isEmpty() && st.peek() < k) {
                st.pop();
                as.pop();
            }

            if (st.isEmpty()) {
                answer[i] = 0;
                st.push(k);
                as.push(i + 1);
            } else {
                answer[i] = as.peek();
                st.push(k);
                as.push(i + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString());
    }

}
