import java.io.*;
import java.util.*;

public class Main {
    static int n, num, min;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0 || visited[i][j])
                    continue;
                dfs(new Node(i, j));
                num++;
            }
        }

        min = 10000;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0)
                    continue;
                min = Math.min(bfs(new NodeAndCount(i, j, 0)), min);
            }
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    static void dfs(Node node){
        int currentX = node.x;
        int currentY = node.y;
        visited[currentX][currentY] = true;
        map[currentX][currentY] = num;
        for(int i = 0; i < 4; i++){
            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                continue;
            if(map[nextX][nextY] == 0 || visited[nextX][nextY])
                continue;
            dfs(new Node(nextX, nextY));
        }

    }

    static int bfs(NodeAndCount node){
        Queue<NodeAndCount> queue = new LinkedList<>();
        boolean visited1[][] = new boolean[n][n];
        int checkIsland = map[node.x][node.y];
        queue.add(node);
        while(!queue.isEmpty()){
            NodeAndCount current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            visited1[currentX][currentY] = true;
            for(int i = 0 ; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;
                if(visited1[nextX][nextY] || map[nextX][nextY] == checkIsland)
                    continue;
                if(map[nextX][nextY] == 0) {
                    queue.add(new NodeAndCount(nextX, nextY, current.count + 1));
                    visited1[nextX][nextY] = true;
                }

                else
                    return current.count;

            }
        }
        return min;
    }

    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class NodeAndCount{
        int x, y, count;
        public NodeAndCount(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}