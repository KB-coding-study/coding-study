import java.io.*;
import java.util.*;

public class BJ_13549 {
    static int N, K;
    static int[] dx = {-1, 1};
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bw.write(String.valueOf(BFS(new Node(N, 0)) + 1));
        bw.flush();
        bw.close();
    }

    static int BFS(Node node){
        Queue<Node> queue = new LinkedList<>();
        int X = node.N;
        while(X <= 100000){
            queue.add(new Node(X, 0));
            visited[X] = true;
            X *= 2;
            if(X == 0)
                break;
        }

        while(!queue.isEmpty()){
            Node current = queue.poll();
            int currentX = current.N;
            for(int i = 0; i < 2; i++){
                int nextX = currentX + dx[i];
                while(nextX <= 100000 && nextX >= 0 && !visited[nextX]){
                    if(nextX == K)
                        return current.count;
                    queue.add(new Node(nextX, current.count + 1));
                    visited[nextX] = true;
                    nextX *= 2;
                }
            }
        }
        return -1;
    }

    static class Node{
        int N, count;
        public Node(int N, int count){
            this.N = N;
            this.count = count;
        }

    }
}