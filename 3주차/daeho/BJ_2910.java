import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> idxmap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (!idxmap.containsKey(num)) {
                idxmap.put(num, i);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        list.sort((a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) {
                return freqB - freqA;
            } else {
                return idxmap.get(a) - idxmap.get(b);
            }
        });

        for (int num : list) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}