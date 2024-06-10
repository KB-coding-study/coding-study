import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Long> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String s;
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            s = st.nextToken();

            for (int j = s.length() - 1; j >= 0; j--) {
                sb.append(s.charAt(j));
            }
            arrayList.add(Long.parseLong(sb.toString()));
            sb.setLength(0);
        }
        Collections.sort(arrayList);
        sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(arrayList.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}