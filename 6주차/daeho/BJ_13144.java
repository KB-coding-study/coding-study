import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> hashSet = new HashSet<>();

        long count = 0;
        int end = 0;

        for(int i = 0; i < N; i++){
            while(end < N){
                if(!hashSet.contains(arr[end])){
                    hashSet.add(arr[end]);
                    end++;
                }
                else{
                    break;
                }
            }
            count += end - i;
            hashSet.remove(arr[i]);

        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}