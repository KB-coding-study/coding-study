import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class BJ_1600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int map[][] = new int[row][col];
        boolean visited[][][] = new boolean[row][col][k+1];

        int[] diagonalRow = {1 , 2, 2, 1, -1, -2, -2, -1};
        int[] diagonalCol = {-2,-1, 1, 2, -2, -1, 1, 2};
        int[] dRow = {0,0,1,-1};
        int[] dCol = {-1,1,0,0};

        // init map
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Step> queue = new LinkedList<>();
        queue.offer(new Step(0,0,0, 0));
        visited[0][0][0] = true;
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Step current = queue.poll();
            if(current.x == row-1 && current.y == col-1) {
                min = Math.min(min, current.step);
            }
            if(current.step>min) {
                continue;
            }

            //그냥 일반
            for(int i=0; i<4; i++) {
                int nx = dRow[i] + current.x;
                int ny = dCol[i] + current.y;

                if(0<=nx && nx<row && 0<=ny && ny<col && visited[nx][ny][current.count] == false && map[nx][ny]==0) {
                        visited[nx][ny][current.count] = true;
                        queue.offer(new Step(nx,ny, current.count, current.step+1));
                }
            }

            if(current.count < k) {
                //대각선
                for(int i=0; i<8; i++) {
                    int nx = diagonalRow[i] + current.x;
                    int ny = diagonalCol[i] + current.y;

                    if(0<=nx && nx<row && 0<=ny && ny<col && visited[nx][ny][current.count+1]==false && map[nx][ny]==0) {
                        visited[nx][ny][current.count+1] = true;
                        queue.offer(new Step(nx,ny, current.count+1, current.step+1));
                    }
                }
            }
        }
        if(min != Integer.MAX_VALUE) {
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }

   static class Step {
        int x;
        int y;
        int count;
        int step;

        Step(int x, int y, int count, int step) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.step = step;
        }
    }
}
