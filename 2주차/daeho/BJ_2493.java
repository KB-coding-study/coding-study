import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stacknum = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < cnt; i++){
            int k = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek() < k) {
                stack.pop();
                stacknum.pop();
            }
            if(stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(k);
                stacknum.push(i + 1);
            }
            else{
                sb.append(stacknum.peek()).append(" ");
                stack.push(k);
                stacknum.push(i + 1);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}