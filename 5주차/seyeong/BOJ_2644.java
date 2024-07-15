package com.DFS;

import java.util.Scanner;

public class BOJ_2644 {
    static boolean[] visited;
    static int[][] field;
    static int n;
    static int ed;
    static boolean clear = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        visited = new boolean[n + 1];
        field = new int[n + 1][n + 1];

        int st = sc.nextInt();
        ed = sc.nextInt();
        sc.nextLine();

        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            field[x][y] = 1;
            field[y][x] = 1;
        }

        int result = dfs(st, 0);

        if (clear) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static int dfs(int st, int depth) {
        visited[st] = true;

        if (st == ed) {
            clear = true;
            return depth;
        }

        for (int i = 1; i <= n; i++) {
            if (field[st][i] == 1 && !visited[i]) {
                int result = dfs(i, depth + 1);
                if (clear) {
                    return result;
                }
            }
        }

        return -1;
    }
}
