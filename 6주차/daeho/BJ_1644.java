import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        ArrayList<Long> primeSum = new ArrayList<>();
        primeSum.add(Long.valueOf(0));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        for(int i = 2; i <= N; i++){
            arr[i] = i;
        }
        for(int i = 2; i <= N; i++){
            if(arr[i] == 0)
                continue;
            for(int j = 2 * i; j <= N; j += i)
                arr[j] = 0;
        }

        int k = 0;
        for(int i = 2; i <= N; i++){
            if(arr[i] == 0)
                continue;
            primeSum.add(k + 1, arr[i] + primeSum.get(k));
            k++;

        }
        for(int i = k; i > 0; i--){
            if(primeSum.get(i) < N)
                break;
            int n = i - 1;
            while(true){
                if(primeSum.get(i) - primeSum.get(n) > N)
                    break;
                else if(primeSum.get(i) - primeSum.get(n) == N) {
                    count++;
                    break;
                }
                else
                    n--;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}