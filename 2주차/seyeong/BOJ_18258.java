package com.ohgiraffers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    int k = Integer.parseInt(command[1]);
                    q.offer(k);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(q.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(q.peek() + "\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(q.peekLast() + "\n");
                    }
                    break;
                default:
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
