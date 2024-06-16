import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] visit;
    static boolean[][] visit1;
    static int[][] RGB;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        RGB = new int[N][N];
        visit = new boolean[N][N];
        visit1 = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                Character option = s.charAt(j);
                switch (option){
                    case'R':
                        RGB[i][j] = 0;
                        break;
                    case'B':
                        RGB[i][j] = 1;
                        break;
                    case'G':
                        RGB[i][j] = 2;
                        break;
                }
            }
        }

        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (RGB[i][j] % 2 == 0 && !visit[i][j]) {
                    BFS(i, j, 0);
                    count1++;
                    continue;
                }
                if (RGB[i][j] % 2 == 1 && !visit[i][j]) {
                    BFS(i, j, 1);
                    count1++;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(RGB[i][j] == 0 && !visit1[i][j]) {
                    BFS1(i, j , 0);
                    count2++;
                    continue;
                }
                if(RGB[i][j] == 1 && !visit1[i][j]) {
                    BFS1(i, j, 1);
                    count2++;
                    continue;
                }
                if(RGB[i][j] == 2 && !visit1[i][j]) {
                    BFS1(i, j, 2);
                    count2++;
                }
            }
        }
        sb.append(count2).append(" ").append(count1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void BFS(int x, int y, int k){
        Queue<Node> queue= new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;

        while(!queue.isEmpty()){
            Node next = queue.poll();
            for(int i = 0; i < 4; i++){
                int next_x = next.x + dx[i];
                int next_y = next.y + dy[i];
                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N)
                    continue;
                if(visit[next_x][next_y] || (RGB[next_x][next_y] % 2) != k)
                    continue;
                queue.add(new Node(next_x, next_y));
                visit[next_x][next_y] = true;
            }
        }
    }

    static void BFS1(int x, int y, int k){
        Queue<Node> queue= new LinkedList<>();
        queue.add(new Node(x, y));
        visit1[x][y] = true;

        while(!queue.isEmpty()){
            Node next = queue.poll();
            for(int i = 0; i < 4; i++){
                int next_x = next.x + dx[i];
                int next_y = next.y + dy[i];
                if(next_x < 0 || next_y < 0 || next_x >= N || next_y >= N)
                    continue;
                if(visit1[next_x][next_y] || RGB[next_x][next_y] != k)
                    continue;
                queue.add(new Node(next_x, next_y));
                visit1[next_x][next_y] = true;
            }
        }
    }
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
