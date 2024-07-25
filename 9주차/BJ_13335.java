import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] car = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            car[i] = Integer.parseInt(st.nextToken());
        }
        int[] bridge = new int[n];
        int start = 0;
        int end = 0;
        int count = 0;
        int sum = car[0];
        while(bridge[n - 1] < W){
            for(int i = start; i <= end; i++){
                bridge[i]++;
            }
            if(bridge[start] == W){
                sum -= car[start];
                start++;
            }

            if(end < n - 1 && sum + car[end + 1] <= L){
                sum += car[end + 1];
                end++;
            }
            count++;
        }
        bw.write(String.valueOf(count + 1));
        bw.flush();
        bw.close();

    }
}