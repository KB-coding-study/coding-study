import java.util.*;
import java.io.*;
import java.math.*;

public class no2164 {

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        for (int i = 1 ; i <= N ; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.remove();
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}
