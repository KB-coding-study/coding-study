import java.util.*;
import java.io.*;

public class no1967 {
    static ArrayList<Node>[] tree;
    static int N;
    static final int INF = 10_0000_0000;

    static class Node {
        final int end;
        final int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[s].add(new Node(e, c));
            tree[e].add(new Node(s, c));
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> results = dijkstra(1);
        int result = dijkstra(results.get(1)).get(0);
        System.out.println(result);
    }

    static List<Integer> dijkstra(int s) {
        int max = 0;
        int nodeNumber = s;
        int[] table = new int[N + 1];
        Arrays.fill(table, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        pq.add(new Node(s, 0));
        table[s] = 0;

        while (!pq.isEmpty()) {
            Node curN = pq.poll();
            for (Node nextN : tree[curN.end]) {
                if (table[nextN.end] > table[curN.end] + nextN.cost) {
                    table[nextN.end] = table[curN.end] + nextN.cost;
                    pq.add(new Node(nextN.end, table[nextN.end]));
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (i == s) continue;
            if (max < table[i]) {
                max = table[i];
                nodeNumber = i;
            }
        }
        return List.of(max, nodeNumber);
    }
}
