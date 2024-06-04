import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());
        int k = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < cnt; i++){
            int n = Integer.parseInt(br.readLine());
            while(n >= k){
                stack.push(k);
                k++;
                sb.append("+\n");
            } // 오름차순으로 스택에 push해야 하니 읽은 정수까지 스택에 Push
            if(stack.isEmpty() || stack.peek() != n) {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            } // 스택의 peek이 읽은 정수가 아니거나, 스택이 비어있으면 수열을 만들 수 없으므로 NO 출력

            stack.pop();
            sb.append("-\n");
            // stack이 비어있지 않고 peek가 읽은 정수이면 pop연산
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
