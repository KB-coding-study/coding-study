package bongJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testcase = Integer.parseInt(br.readLine());
            StringBuilder stringBuilder = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            int j = 1;
            boolean err = false;

            for (int i = 0; i < testcase; i++) {
                int n = Integer.parseInt(br.readLine());
                while (j <= n) {
                    stack.push(j);
                    stringBuilder.append("+").append("\n");
                    j++;
                }
                if (stack.peek() == n) {
                    stack.pop();
                    stringBuilder.append("-").append("\n");
                } else {
                    err = true;
                    break;
                }
            }
            if (err) {
                System.out.println("NO");
            } else {
                System.out.println(stringBuilder.toString());
            }
        }
    }

}
