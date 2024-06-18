package com.ohgiraffers;

import java.util.*;

public class BOJ_2206 {
    static class Node {
        int x, y, dist, breakWall;

        Node(int x, int y, int dist, int breakWall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.breakWall = breakWall;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(map, n, m));
    }

    private static int bfs(int[][] map, int n, int m) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        boolean[][][] visited = new boolean[n][m][2];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][node.breakWall]) {
                        visited[nx][ny][node.breakWall] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, node.breakWall));
                    }

                    if (map[nx][ny] == 1 && node.breakWall == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, 1));
                    }
                }
            }
        }

        return -1;
    }
}
