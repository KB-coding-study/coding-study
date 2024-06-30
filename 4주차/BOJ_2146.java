package com.ohgiraffers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2146 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 섬 구분
        int islandId = 2;  // 섬 번호는 2부터 시작 (1은 입력에서 사용되었으므로)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, islandId);
                    islandId++;
                }
            }
        }

        // 가장 짧은 다리 길이 찾기
        int shortestBridge = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) {
                    shortestBridge = Math.min(shortestBridge, findShortestBridge(i, j, map[i][j]));
                }
            }
        }

        System.out.println(shortestBridge);
    }

    // 섬 구분을 위한 BFS
    static void bfs(int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = id;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = id;
                }
            }
        }
    }

    // 다리 놓기를 위한 BFS
    static int findShortestBridge(int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        queue.add(new int[]{x, y, 0});  // x, y, 거리
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int dist = current[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] != 0 && map[nx][ny] != id) {
                        return dist;
                    }

                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;  // 이 경우는 발생하지 않음
    }
}
