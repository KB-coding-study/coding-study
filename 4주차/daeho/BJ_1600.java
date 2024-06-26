import java.io.*;
import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx1 = {1, -1, 0, 0};
    static int[] dy1 = {0, 0, 1, -1};
    static int[] dx2 = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy2 = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[W][H];
        visited = new boolean[W][H][K + 1];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        if(W == 1 && H == 1)
            bw.write("0");
        else {
            bw.write(String.valueOf(BFS()));
        }
        bw.flush();
        bw.close();
    }

    static int BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int countk = current.k;
            for(int i = 0; i < 4; i++){
                int nextX2 = current.x + dx1[i];
                int nextY2 = current.y + dy1[i];
                if(nextX2 == W - 1 && nextY2 == H - 1)
                    return current.count + 1;
                if(nextX2 < 0 || nextY2 < 0 || nextX2 >= W || nextY2 >= H || visited[nextX2][nextY2][countk] ||map[nextX2][nextY2] == 1)
                    continue;
                queue.add(new Node(nextX2, nextY2, current.count + 1, countk));
                visited[nextX2][nextY2][countk] = true;
            }
            if(countk < K){
                countk++;
                for(int i = 0; i < 8; i++){
                    int nextX1 = current.x + dx2[i];
                    int nextY1 = current.y + dy2[i];
                    if(nextX1 == W - 1 && nextY1 == H - 1)
                        return current.count + 1;
                    if(nextX1 < 0 || nextY1 < 0 || nextX1 >= W || nextY1 >= H || visited[nextX1][nextY1][countk] || map[nextX1][nextY1] == 1)
                        continue;
                    queue.add(new Node(nextX1, nextY1, current.count + 1, countk));
                    visited[nextX1][nextY1][countk] = true;
                }
            }

        }
        return -1;
    }

    static class Node{
        int x, y, count, k;
        public Node(int x, int y, int count, int k){
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
}