package com.simulation;

import java.util.Scanner;

public class BOJ_14888 {

    static public int max = Integer.MIN_VALUE;
    static public int min = Integer.MAX_VALUE;
    static public int[] cal = new int[4];
    static public int[] arr;
    static public int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            cal[i] = sc.nextInt();
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int sum, int depth) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] != 0) {
                cal[i]--;
                if (i == 0) {
                    dfs(sum + arr[depth], depth + 1);
                } else if (i == 1) {
                    dfs(sum - arr[depth], depth + 1);
                } else if (i == 2) {
                    dfs(sum * arr[depth], depth + 1);
                } else if (i == 3) {
                    if (arr[depth] != 0) { 
                        dfs(sum / arr[depth], depth + 1);
                    }
                }
                cal[i]++;
            }
        }
    }
}
