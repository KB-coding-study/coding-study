package com.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class rt_11599 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static char[][] field = new char[12][6];
    public static boolean[][] visited = new boolean[12][6];
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 12; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = s.charAt(j);
            }
        }

        boolean found = true;
        while (found) {
            found = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j, field[i][j])) {
                            found = true;
                        }
                    }
                }
            }

            if (found) {
                downPP();
                answer++;
            }
        }

//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(field[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(answer);
    }

    private static void downPP() {
        for (int j = 0; j < 6; j++) {
            Queue<Character> queue = new LinkedList<>();
            for (int i = 11; i >= 0; i--) {
                if (field[i][j] != '.') {
                    queue.add(field[i][j]);
                    field[i][j] = '.';
                }
            }
            int index = 11;
            while (!queue.isEmpty()) {
                field[index--][j] = queue.poll();
            }
        }
    }

    private static boolean bfs(int x, int y, char color) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> toRemove = new LinkedList<>();
        queue.add(new int[]{x, y});
        toRemove.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && field[nx][ny] == color) {
                    queue.add(new int[]{nx, ny});
                    toRemove.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        if (count >= 4) {
            while (!toRemove.isEmpty()) {
                int[] point = toRemove.poll();
                field[point[0]][point[1]] = '.';
            }
            return true;
        }

        return false;
    }
}
