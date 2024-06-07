package bongJ;

import java.io.*;
import java.util.*;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new int[]{i + 1, num});
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new int[]{i + 1, num});
                        break;
                    } else {
                        if (stack.peek()[1] > num) {
                            sb.append(stack.peek()[0] +" ");
                            stack.push(new int[]{i + 1, num});
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
            }

        }
        System.out.println(sb);
    }
}
