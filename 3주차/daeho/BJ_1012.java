import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;
    static int[][] bug;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0}; // 현재 위치를 기준 으로 상하 좌우 탐색할 x, y 좌표 지정
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            bug = new int[M][N];
            visit = new boolean[M][N];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                bug[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; // 변수들 모두 초기화
            }

            int count = 0;
            for(int j = 0; j < M; j++){
                for(int k = 0; k < N; k++){
                    if(bug[j][k] == 1 && !visit[j][k]) {
                        bfs(j, k); // 방문 하지 않은 노드 중에서 배추가 인접해 있는 곳을 BFS로 탐색
                        count++; // 탐색이 끝나면 count 증가
                    }
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>(); // LinkedList로 BFS로 구현
        queue.add(new Node(x, y));
        visit[x][y] = true; // 방문한 노드 true, 큐에 Node로 저장

        while (!queue.isEmpty()) { // 큐가 빌 때 까지 (즉 인접한 노드 중에 방문 하지 않았고, 배추가 존재 하는 경우가 없을 떄 까지)
            Node xy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = xy.x + dx[i];
                int yy = xy.y + dy[i]; // 상하 좌우 인접 노드 계산

                if(range(xx, yy))
                    continue;
                if(visit[xx][yy] || bug[xx][yy] != 1)
                    continue;
                // 인접 노드의 x, y 범위가 주어진 범위 내에 있으며, 방문 하지 않았고 배추가 존재할 때에만 큐에 추가
                queue.add(new Node(xx, yy));
                visit[xx][yy] = true;

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

    public static boolean range(int x, int y) {
        return (x < 0 || x >= M || y < 0 || y >= N);
    }
}
