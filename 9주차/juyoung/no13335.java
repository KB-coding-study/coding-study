import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int count = 0;
        int bridgeWeight = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            count++;
            bridgeWeight-=bridge.poll();
            if (!truck.isEmpty()) {
                if (truck.peek() + bridgeWeight <= L) {
                    bridgeWeight += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }
        System.out.println(count);

    }
}
