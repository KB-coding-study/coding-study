package bongJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기 N
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려는 수의 개수 M

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i); // 큐에 1부터 N까지 저장
        }

        st = new StringTokenizer(br.readLine());
        int[] getArr = new int[M]; // 배열 선언

        for (int i = 0; i < M; i++) {
            getArr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            int target = getArr[i];
            int targetIndex = queue.indexOf(target); // 목표 인덱스 찾기
            int halfIndex = queue.size() / 2; // 중간 인덱스

            if (targetIndex <= halfIndex) {
                //왼쪽
                for (int j = 0; j < targetIndex; j++) {
                    queue.addLast(queue.pollFirst());
                    count++;
                }
            } else {
                //오른쪽
                for (int j = 0; j < queue.size() - targetIndex; j++) {
                    queue.addFirst(queue.pollLast());
                    count++;
                }
            }
            queue.pollFirst();
        }
        System.out.println(count);
    }
}