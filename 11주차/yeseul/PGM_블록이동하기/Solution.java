package PGM_블록이동하기;

import java.util.*;

public class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] ddx = {-1, 1, 1, -1};
    static int[] ddy = {1, 1, -1, -1};

    public int solution(int[][] board) {
        int answer = 0;
        return answer;
    }

    static int bfs(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] tmp = new int[board.length][board[0].length];
        int cnt = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; i++) {
                tmp[i][j] = board[i][j];
            }
        }

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] xy = q.poll();


            // (N, N)위치에 닿으면 종료
            if ((xy[0] == board.length - 2 && xy[1] == board[0].length - 2) ||
                    (xy[0] == board.length - 1 && xy[1] == board[0].length - 2) ||
                    (xy[0] == board.length - 2 && xy[1] == board[0].length - 1)) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + xy[0];
                int ny = dy[i] + xy[1];

                if (nx >= board.length || ny >= board.length || nx < 0 || ny < 0) continue;
                if (tmp[nx][ny] == 1) continue;
            }
        }
        return cnt;
    }
}
