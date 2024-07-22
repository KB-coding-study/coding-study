package com.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_13023 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextLine();

            graph[x].add(y);
            graph[y].add(x);
        }

        boolean found = false;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (dfs(i, 1)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean dfs(int node, int depth) {
        if (depth == 5) {
            return true;
        }

        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, depth + 1)) {
                    return true;
                }
            }
        }

        visited[node] = false;
        return false;
    }

}
