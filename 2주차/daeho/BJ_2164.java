import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            deque.add(i);
        }

        for(int i = 1; i < N; i++){
            deque.pop();
            deque.addLast(deque.pop());
        }
        bw.write(String.valueOf(deque.peek()));
        bw.flush();
        bw.close();
    }
}
