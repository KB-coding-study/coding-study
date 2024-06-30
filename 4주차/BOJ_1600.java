package com.ohgiraffers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1600 {


    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static final int[] horseDx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] horseDy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();

        int[][] grid = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs(grid, K, W, H));
    }

    private static int bfs(int[][] grid, int K, int W, int H) {

        boolean[][][] visited = new boolean[H][W][K + 1];
        Queue<Node> queue = new LinkedList<>();


        queue.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == H - 1 && current.y == W - 1) {
                return current.moves;
            }

            // Normal moves
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (isInBounds(nx, ny, W, H) && grid[nx][ny] == 0 && !visited[nx][ny][current.horseMoves]) {
                    visited[nx][ny][current.horseMoves] = true;
                    queue.offer(new Node(nx, ny, current.horseMoves, current.moves + 1));
                }
            }

            // Horse moves
            if (current.horseMoves < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + horseDx[i];
                    int ny = current.y + horseDy[i];
                    if (isInBounds(nx, ny, W, H) && grid[nx][ny] == 0 && !visited[nx][ny][current.horseMoves + 1]) {
                        visited[nx][ny][current.horseMoves + 1] = true;
                        queue.offer(new Node(nx, ny, current.horseMoves + 1, current.moves + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isInBounds(int x, int y, int W, int H) {
        return x >= 0 && y >= 0 && x < H && y < W;
    }

    private static class Node {
        int x, y, horseMoves, moves;

        Node(int x, int y, int horseMoves, int moves) {
            this.x = x;
            this.y = y;
            this.horseMoves = horseMoves;
            this.moves = moves;
        }
    }
}
