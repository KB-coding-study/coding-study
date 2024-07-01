import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <=N; i++){
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1;
        while(end <= N){
            if(sum[end] - sum[start] == M){
                count++;
                end++;
                start++;
            }
            else if(sum[end] - sum[start] > M){
                start++;
            }
            else{
                end++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
