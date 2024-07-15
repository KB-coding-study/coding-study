import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            List<Integer> vv = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                vv.add(Integer.parseInt(st.nextToken()));

                if (i > 0) {
                    if (j > 0) {
                        if (j == i)
                            vv.set(j, vv.get(j) + v.get(i - 1).get(j - 1));
                        else
                            vv.set(j, vv.get(j) + Math.max(v.get(i - 1).get(j - 1), v.get(i - 1).get(j)));
                    }
                    else
                        vv.set(j, vv.get(j) + v.get(i - 1).get(j));
                }
            }
            v.add(vv);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(Collections.max(v.get(n - 1))));
        bw.close();
    }
}