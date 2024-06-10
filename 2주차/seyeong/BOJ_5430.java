package com.ohgiraffers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String functions = sc.nextLine();
            int k = sc.nextInt();
            sc.nextLine();

            String inputArray = sc.nextLine();
            inputArray = inputArray.substring(1, inputArray.length() - 1);

            Deque<Integer> deque = new LinkedList<>();
            if (!inputArray.isEmpty()) {
                String[] elements = inputArray.split(",");
                for (String element : elements) {
                    deque.offer(Integer.parseInt(element.trim()));
                }
            }

            boolean isReversed = false;
            boolean error = false;

            for (char function : functions.toCharArray()) {
                if (function == 'R') {
                    isReversed = !isReversed;
                } else if (function == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder result = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    if (isReversed) {
                        result.append(deque.pollLast());
                    } else {
                        result.append(deque.pollFirst());
                    }
                    if (!deque.isEmpty()) {
                        result.append(",");
                    }
                }
                result.append("]");
                System.out.println(result.toString());
            }
        }
    }
}
