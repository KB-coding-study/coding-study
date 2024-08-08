package week11;

public class programmers60063 {
    /*
    * import java.util.*;

class Solution {
    public int solution(int[][] board) {
        final int n = board.length;
        //✅ 인덱싱의 편의를 위해 원본 배열에 상하좌우로 한 칸씩 늘린 새 배열을 만든다.
        int[][] newBoard = new int[n+2][n+2];
        //✅ 배열의 모서리 부분을 1로 채우고 내부를 원본 배열의 값들로 채운다.
        for (int r = 0; r < n+2; r++) {
            newBoard[r][0] = 1;
            newBoard[r][n+1] = 1;
        }
        for (int c = 0; c < n+2; c++) {
            newBoard[0][c] = 1;
            newBoard[n+1][c] = 1;
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                newBoard[r+1][c+1] = board[r][c];
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        //✅ 로봇의 첫 위치를 방문표시하고 큐에 추가한다.
        queue.add(new int[]{ 1, 1, 1, 2, 0 });
        // 방문을 표시하기 위해 회전상태를 구한다.
        boolean[][][] visited = new boolean[n+2][n+2][2];
        visited[1][1][0] = true;

        //✅ 큐가 빌때까지 반복한다.
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            final int r1 = cur[0], c1 = cur[1];
            final int r2 = cur[2], c2 = cur[3];
            final int dist = cur[4];
            int d = 0;
            if (c1 == c2) d = 1;

            //✅ 목적지에 도착한 경우 종료한다.
            if (r2 == n && c2 == n)
                return dist;

            //✅ 현재 상태에서 이동가능한 상태를 구한다.
            for (int[] pos : getNextPos(cur, newBoard)) {
                int nd = 0;
                if (pos[1] == pos[3]) nd = 1;

								//✅ 아직 방문하지 않았다면 방문한다.
                if (!visited[pos[0]][pos[1]][nd]) {
                    queue.add(new int[]{ pos[0], pos[1], pos[2], pos[3], dist+1 });
                    visited[pos[0]][pos[1]][nd] = true;
                }
            }
        }
        return -1;
    }

    // 다음에 방문 가능한 위치들을 구한다.
    // ❗️ 다음 위치는 반드시 첫 번째 위치가 왼쪽 위의 위치여야 한다.
    List<int[]> getNextPos(int[] pos, int[][] board) {
        final int[] dr = {  0,  1,  0, -1 };
        final int[] dc = {  1,  0, -1,  0 };
        final int r1 = pos[0], c1 = pos[1], r2 = pos[2], c2 = pos[3];
        List<int[]> nextPosList = new ArrayList<>();
        //✅ 상하좌우 이동이 가능한 경우를 구한다.
        for (int d = 0; d < 4; d++) {
            int nr1 = r1+dr[d], nc1 = c1+dc[d];
            int nr2 = r2+dr[d], nc2 = c2+dc[d];
            if (board[nr1][nc1] == 0 && board[nr2][nc2] == 0) {
                nextPosList.add(new int[]{ nr1, nc1, nr2, nc2 });
            }
        }
        //✅ 가로 방향일 경우 회전 가능한 경우를 구한다.
        if (r1 == r2) {
            if (board[r1-1][c1] == 0 && board[r2-1][c2] == 0) {
                nextPosList.add(new int[]{ r2-1, c2, r2, c2 });
                nextPosList.add(new int[]{ r1-1, c1, r1, c1 });
            }
            if (board[r1+1][c1] == 0 && board[r2+1][c2] == 0) {
                nextPosList.add(new int[]{ r2, c2, r2+1, c2 });
                nextPosList.add(new int[]{ r1, c1, r1+1, c1 });
            }
        }
        //✅ 세로 방향일 경우 회전 가능한 경우를 구한다.
        if (c1 == c2) {
            if (board[r1][c1-1] == 0 && board[r2][c2-1] == 0) {
                nextPosList.add(new int[]{ r2, c2-1, r2, c2 });
                nextPosList.add(new int[]{ r1, c1-1, r1, c1 });
            }
            if (board[r1][c1+1] == 0 && board[r2][c2+1] == 0) {
                nextPosList.add(new int[]{ r2, c2, r2, c2+1 });
                nextPosList.add(new int[]{ r1, c1, r1, c1+1 });
            }
        }

        return nextPosList;
    }
}*/

}
