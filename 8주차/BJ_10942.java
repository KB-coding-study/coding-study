import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(fal(S - 1, E - 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int fal(int start, int end){
        while(start < end){
            if(arr[start++] != arr[end--])
                return 0;
        }
        return 1;
    }
}