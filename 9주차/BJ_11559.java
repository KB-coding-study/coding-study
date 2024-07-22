import java.io.*;
import java.util.*;

public class Main{
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new char[12][6];
        for(int i = 0; i < 12; i++){
            String s = br.readLine();
            for(int j = 0; j < 6; j++){
                map[i][j] = s.charAt(j);
            }
        }
        answer = 0;
        boolean changed;

        do {
            changed = false;
            for(int i = 11; i >= 0; i--){
                for(int j = 0; j < 6; j++){
                    if(map[i][j] != '.') {
                        visited = new boolean[12][6];
                        if(BFS(j, i)) {
                            changed = true;
                        }
                    }
                }
            }
            if (changed) {
                applyGravity();
                answer++;
            }
        } while(changed);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static boolean BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        List<Node> remove = new LinkedList<>();
        queue.add(new Node(x, y));
        remove.add(new Node(x, y));
        count = 1;
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= 6 || ny >= 12 || map[ny][nx] == '.' || map[ny][nx] != map[current.y][current.x] || visited[ny][nx])
                    continue;
                queue.add(new Node(nx, ny));
                remove.add(new Node(nx, ny));
                visited[ny][nx] = true;
                count++;
            }
        }
        if(count >= 4){
            for(Node node : remove){
                map[node.y][node.x] = '.';
            }
            return true;
        }
        return false;
    }

    static void applyGravity(){
        for(int j = 0; j < 6; j++){
            int emptyRow = 11;
            for(int i = 11; i >= 0; i--){
                if(map[i][j] != '.'){
                    if(emptyRow != i){
                        map[emptyRow][j] = map[i][j];
                        map[i][j] = '.';
                    }
                    emptyRow--;
                }
            }
        }
    }

    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
