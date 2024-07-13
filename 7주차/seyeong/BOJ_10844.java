package com.dp;

import java.util.Scanner;

public class BOJ_10844 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n + 1][10];

        if (n >= 1) {
            arr[1][0] = 0;
            arr[1][1] = 1;
            arr[1][2] = 1;
            arr[1][3] = 1;
            arr[1][4] = 1;
            arr[1][5] = 1;
            arr[1][6] = 1;
            arr[1][7] = 1;
            arr[1][8] = 1;
            arr[1][9] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    arr[i][j] = arr[i - 1][j - 1] % 1000000000;
                } else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
                }


            }

        }

        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += arr[n][i];

        }
        answer %= 1000000000;

        System.out.println(answer);


    }

}
