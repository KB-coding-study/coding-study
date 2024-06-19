package com.ohgiraffers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2573 {
    static int N, M;
    static int[][] iceberg;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = sc.nextInt();
            }
        }

        int year = 0;
        while (true) {
            int count = countIcebergParts();
            if (count >= 2) {
                System.out.println(year);
                break;
            } else if (count == 0) {
                System.out.println(0);
                break;
            }

            meltIceberg();
            year++;
        }
    }

    static int countIcebergParts() {
        visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (iceberg[nx][ny] > 0 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void meltIceberg() {
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] > 0) {
                    int water = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (iceberg[nx][ny] == 0) {
                                water++;
                            }
                        }
                    }
                    temp[i][j] = Math.max(iceberg[i][j] - water, 0);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = temp[i][j];
            }
        }
    }
}
