import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while (end < N) {
            hashMap.put(arr[end], hashMap.getOrDefault(arr[end], 0) + 1);

            while (hashMap.get(arr[end]) > K) {
                hashMap.put(arr[start], hashMap.get(arr[start]) - 1);
                if (hashMap.get(arr[start]) == 0) {
                    hashMap.remove(arr[start]);
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
