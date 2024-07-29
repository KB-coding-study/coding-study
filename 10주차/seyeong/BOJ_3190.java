package com.simulation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_3190 {
    static public int[][] field;
    public static int[] dx = {0, 1, 0, -1}; 
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int K = sc.nextInt();
        sc.nextLine();
        field = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            field[x][y] = 1;
        }

        int L = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int x = sc.nextInt();
            char ch = sc.next().charAt(0);
            map.put(x, ch);
        }

        int time = 0;
        field[1][1] = 2;
        int[] head = new int[2];
        head[0] = 1;
        head[1] = 1;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{1, 1});
        int loca = 0;

        while (true) {
            time++;
            int nx = head[0] + dx[loca];
            int ny = head[1] + dy[loca];

            if (nx <= 0 || ny <= 0 || nx > N || ny > N || field[nx][ny] == 2) {
                break;
            }

            if (field[nx][ny] == 1) {
                field[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else {
                field[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.pollLast();
                field[tail[0]][tail[1]] = 0;
            }

            if (map.containsKey(time)) {
                char turn = map.get(time);
                if (turn == 'L') {
                    loca = (loca + 3) % 4;
                } else if (turn == 'D') {
                    loca = (loca + 1) % 4;
                }
            }

            head[0] = nx;
            head[1] = ny;
        }

        System.out.println(time);
    }
}
