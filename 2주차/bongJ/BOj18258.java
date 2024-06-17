package bongJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int i = 0;

        for (int j = 0; j < N; j++) {
            String raw_cmd = br.readLine();
            String cmd = raw_cmd.split(" ")[0];
            if (cmd.equals("push")) {
                i = Integer.parseInt(raw_cmd.split(" ")[1]);
                queue.add(i);
            } else if (cmd.equals("pop")) {
                Integer num = queue.poll();
                bw.write(((num == null) ? -1 : num) + "\n");
            } else if (cmd.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (cmd.equals("empty")) {
                bw.write((queue.isEmpty() ? 1 : 0) + "\n");
            } else if (cmd.equals("front")) {
                bw.write((queue.size() == 0 ? -1 : queue.peek()) + "\n");
            } else if (cmd.equals("back")) {
                bw.write((queue.size() == 0 ? -1 : i) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
