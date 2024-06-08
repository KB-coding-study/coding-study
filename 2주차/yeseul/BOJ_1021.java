import java.io.*;
import java.util.*;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.offer(i + 1);
        }

        int[] target = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int targetIdx = getIdx(deque, target[i]);
            // 덱의 첫 번째 요소가 타겟과 같을 때 까지 회전 연산
            while (deque.peekFirst() != target[i]) {
                int second = Math.abs(targetIdx - 1);  // 두 번째 회전 연산 했을 때의 값
                int third = Math.abs(targetIdx - deque.size()); // 세 번째 회전 연산 했을 때의 값
                // 두 개의 회전 연산 값 중, 더 작은 쪽으로 회전
                if (second > third) {
                    deque.offerFirst(deque.pollLast());
                    result++;
                } else {
                    deque.offerLast(deque.pollFirst());
                    result++;
                }
            }
            deque.pollFirst();  // 덱에서 타겟 요소 제거
        }
        System.out.println(result);
    }

    // 덱의 타겟 요소의 인덱스를 구하는 메소드 구현
    static int getIdx(Deque<Integer> deque, int target) {
        Deque<Integer> de = new ArrayDeque<>(deque);
        for (int i = 0; i < deque.size(); i++) {
            if (de.pollFirst() == target) return i + 1;
        }
        return 0;
    }
}
