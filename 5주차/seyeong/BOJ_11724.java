package com.DFS;

import java.util.Scanner;

public class BOJ_11724 {
    static int[][] field;
    static boolean[] visited;
    static int cnt = 0;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        field = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            field[x][y] = 1;
            field[y][x] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(!visited[j] && field[i][j] == 1){
                    dfs(j);
                    cnt++;
                }
            }
        }

//       for(int i = 1; i <= N; i++){
//           for(int j = 1; j <= N; j++){
//               System.out.print(field[i][j]);
//           }
//           System.out.println();
//       }

        System.out.println(cnt);
    }

    private static void dfs(int j) {
        visited[j] = true;

        for (int k = 1; k <= N; k++) {
            if(visited[k] || field[j][k] != 1){
                continue;
            }   
            dfs(k);
        }


    }

}
