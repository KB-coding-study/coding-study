import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] positions = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            int idx = 0;

            for (int num : deque) {
                if (num == positions[i]) {
                    break;
                }
                idx++;
            }

            if (idx <= deque.size() / 2) {
                for (int j = 0; j < idx; j++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - idx; j++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
