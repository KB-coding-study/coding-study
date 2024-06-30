package com.DFS;

import java.util.Scanner;
import java.util.ArrayList;

public class BOJ_2668 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        result.sort(Integer::compareTo);

        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        int next = arr[start];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int i = next; i != start; i = arr[i]) {
                result.add(i);
            }
            result.add(start);
        }

        finished[start] = true;
    }
}
