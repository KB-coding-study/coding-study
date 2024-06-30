import java.io.*;
import java.util.*;

public class BOJ13549 {

    static class node {
        int to;
        int w;

        public node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] dist = new int[100001];
        boolean[] visited = new boolean[100001];
        Arrays.fill(dist, -1);
        dist[n] = 0;
        visited[n] = true;
        LinkedList<node> dq = new LinkedList<>();
        dq.add(new node(n, 0));


        while (!dq.isEmpty()) {
            node now = dq.poll();
            node[] next = {
                    new node(now.to * 2, 0),
                    new node(now.to - 1, 1),
                    new node(now.to + 1, 1)
            };
            for (node cur : next) {
                if (cur.to < 0 || cur.to > 100000) continue; // out of bounds
                if (!visited[cur.to]) {
                    visited[cur.to] = true;
                    if (cur.w == 0) { // 순간이동
                        dist[cur.to] = dist[now.to];
                        dq.addFirst(new node(cur.to, cur.w));
                    } else { // 걸어감
                        dist[cur.to] = dist[now.to] + cur.w;
                        dq.addLast(new node(cur.to, cur.w));
                    }
                }
            }
        }

        bw.write(dist[k] + "\n");
        bw.flush();
        bw.close();
    }
}