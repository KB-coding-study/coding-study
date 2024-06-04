package com.ohgiraffers;

import java.util.Scanner;
import java.util.Stack;

public class bj1874 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        boolean clear = true;

        for (int i = 0; i < n; i++) {
            while (cnt < arr[i]) {
                cnt++;
                st.push(cnt);
                sb.append("+\n");
            }

            if (st.peek() == arr[i]) {
                st.pop();
                sb.append("-\n");
            } else {
                clear = false;
                break;
            }
        }

        if (clear) {
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
