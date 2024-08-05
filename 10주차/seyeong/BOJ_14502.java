package com.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502 {
    static public int[][] field;
    static public int[][] check;
    static public int answer = 0;
    static public int[] dx = {0, 1, 0, -1};
    static public int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                field[i][j] = sc.nextInt();
            }

        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int cnt) {

        if (cnt == 3) {
            check = new int[field.length][field[0].length];
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    check[i][j] = field[i][j];
                }
            }

            for (int i = 0; i < check.length; i++) {
                for (int j = 0; j < check[i].length; j++) {
                    if (check[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }
            int zeroCnt = 0;

            for (int i = 0; i < check.length; i++) {
                for (int j = 0; j < check[i].length; j++) {
                    if (check[i][j] == 0) {
                        zeroCnt++;
                    }
                }
            }
            answer = Math.max(zeroCnt, answer);
            return;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 0) {

                    field[i][j] = 1;
                    dfs(cnt + 1);
                    field[i][j] = 0;

                }
            }
        }

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] arr = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                if (nx >= 0 && nx < check.length && ny >= 0 && ny < check[0].length && check[nx][ny] == 0) {
                    check[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }


        }

    }


}
