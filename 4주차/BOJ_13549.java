package com.ohgiraffers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549 {
    static int MAX = 100000;
    static int[] dx = {-1, 1};
    static boolean[] visited = new boolean[MAX + 1];

    static class Subin {
        int x;
        int count;

        public Subin(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int answer = bfs(N, K);
        System.out.println(answer);
    }

    private static int bfs(int start, int target) {
        Queue<Subin> q = new LinkedList<>();
        q.offer(new Subin(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Subin sub = q.poll();
            int x = sub.x;
            int count = sub.count;

            if (x == target) {
                return count;
            }

            // 순간이동 경우
            for (int i = x * 2; i <= MAX && i > 0 && !visited[i]; i *= 2) {
                if (i == target) {
                    return count;
                }
                q.offer(new Subin(i, count));
                visited[i] = true;
            }

            // 걷는 경우
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                if (nx >= 0 && nx <= MAX && !visited[nx]) {
                    if (nx == target) {
                        return count + 1;
                    }
                    q.offer(new Subin(nx, count + 1));
                    visited[nx] = true;
                }
            }
        }
        return -1; // 이 코드는 실행되지 않습니다. (주어진 조건에서는 무조건 도달 가능)
    }
}
