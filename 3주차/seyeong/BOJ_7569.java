package com.ohgiraffers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569 {
    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Tomato {
        int x, y, z;
        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        Queue<Tomato> queue = new LinkedList<>();


        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = sc.nextInt();
                    if (box[z][y][x] == 1) {
                        queue.add(new Tomato(x, y, z));
                        visited[z][y][x] = true;
                    }
                }
            }
        }


        int days = bfs(queue);


        if (allRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    static int bfs(Queue<Tomato> queue) {
        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tomato t = queue.poll();
                int x = t.x;
                int y = t.y;
                int z = t.z;

                for (int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && !visited[nz][ny][nx] && box[nz][ny][nx] == 0) {
                        visited[nz][ny][nx] = true;
                        box[nz][ny][nx] = 1;
                        queue.add(new Tomato(nx, ny, nz));
                    }
                }
            }
            days++;
        }
        return days;
    }

    static boolean allRipe() {
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
