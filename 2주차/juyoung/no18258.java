import java.io.*;
import java.util.*;

public class no18258 {

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int last = 0;

        q = new LinkedList<Integer>();
        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            if (str.startsWith("push")) {
                last = Integer.parseInt(str.split(" ")[1]);
                q.offer(last);
            } else if (str.equals("pop")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else if (str.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (str.equals("empty")) {
                if (q.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (str.equals("front")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.peek() + "\n");
                }
            } else if (str.equals("back")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(last + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
