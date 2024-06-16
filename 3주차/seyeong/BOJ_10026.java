package com.ohgiraffers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {

    static int N;
    static String S;
    static char[][] arr;
    static boolean[][] visits;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N + 1][N + 1];
        visits = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = S.charAt(j);
            }
        }


        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visits[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;
        cnt = 0;
        visits = new boolean[N + 1][N + 1];



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visits[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;
        System.out.println(normal_cnt + " " + abnormal_cnt);

    }

    public static void dfs(int x, int y) {
        visits[x][y] = true;
        char tmp_char = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if (new_x < 0 || new_y < 0 || new_x > N || new_y > N) {
                continue;
            }

            if (!visits[new_x][new_y] && arr[new_x][new_y] == tmp_char) {
                dfs(new_x, new_y);
            }
        }
    }
}
