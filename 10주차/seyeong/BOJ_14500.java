package com.simulation;

import java.util.Scanner;

public class BOJ_14500 {

    static public int[] dx = {0, 0, 1, -1};
    static public int[] dy = {1, -1, 0, 0};
    static public boolean[][] visited;
    static public int[][] field;
    static public int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        field = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                field[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                visited[i][j] = true;
                dfs(i, j, 1,field[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);


    }

    private static void dfs(int x, int y, int depth, int sum) {


        if(depth == 4){
            answer = Math.max(answer, sum);
            visited[x][y] = false;

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && nx < field.length && ny >= 0 && ny < field[0].length && !visited[nx][ny]) {
                visited[nx][ny] = true;
                if (depth == 2) {
                    dfs(x, y, depth + 1, sum + field[nx][ny]);
                    visited[nx][ny] = false;
                }

                dfs(nx, ny, depth + 1, sum + field[nx][ny]);
                visited[nx][ny] = false;


            }else{
                continue;
            }

        }


    }

}
