import java.io.*;
import java.util.*;

public class Main {
    static int T, w, h, startX, startY;
    static boolean[][] fired;
    static boolean[][] visited;
    static int[][] map;
    static Queue<Node> fire;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[w][h];
            fired = new boolean[w][h];
            visited = new boolean[w][h];
            fire = new LinkedList<>();

            for(int j = 0; j < h; j++){
                String line = br.readLine();
                for(int k = 0; k < w; k++){
                    Character option = line.charAt(k);
                    switch (option){
                        case '#':
                            map[k][j] = -1;
                            break;
                        case '.':
                            map[k][j] = 0;
                            break;
                        case '*':
                            map[k][j] = 1;
                            fire.add(new Node(k, j, 0));
                            fired[k][j] = true;
                            break;
                        case '@':
                            startX = k;
                            startY = j;
                            break;
                    }
                }
            }
            int result = BFS();
            if(result == -1)
                sb.append("IMPOSSIBLE").append("\n");
            else
                sb.append(result + 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;
        while(!queue.isEmpty()){
            int fireSize = fire.size();
            for(int i = 0; i < fireSize; i++){
                Node currentfire = fire.poll();
                for(int j = 0; j < 4; j++){
                    int nextfireX = currentfire.x + dx[j];
                    int nextfireY = currentfire.y + dy[j];

                    if(nextfireX < 0 || nextfireY < 0 || nextfireX >= w || nextfireY >= h)
                        continue;
                    if(fired[nextfireX][nextfireY] || map[nextfireX][nextfireY] == -1)
                        continue;
                    fire.add(new Node(nextfireX, nextfireY, currentfire.count + 1));
                    fired[nextfireX][nextfireY] = true;
                }
            }
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                Node current = queue.poll();
                if (current.y == 0 || current.x == 0 || current.x == w - 1 || current.y == h - 1)
                    return current.count;

                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    if (visited[nx][ny] || fired[nx][ny] || map[nx][ny] == -1)
                        continue;
                    queue.add(new Node(nx, ny, current.count + 1));
                    visited[nx][ny] = true;
                }
            }

        }
        return -1;
    }

    static class Node{
        int x, y, count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
