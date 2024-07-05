import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr=  new int[N + k - 1];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = N; i < N + k - 1; i++){
            arr[i] = arr[i - N];
        }

        HashSet<Integer> hashSet = new HashSet();

        int max = 0;

        for(int i = 0; i < N; i++){
            hashSet.clear();
            for(int j = 0; j < k; j++){
                hashSet.add(arr[i + j]);
            }
            if(hashSet.contains(c))
                max = Math.max(max, hashSet.size());
            else
                max = Math.max(max, hashSet.size() + 1);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
}
