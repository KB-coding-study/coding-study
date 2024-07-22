import java.io.*;
import java.util.*;

public class no9084 {
    static int[] coin;
    static int[][] DP;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            coin = new int[N+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<=N;i++)
                coin[i] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());
            DP = new int[N+1][M+1];
            for(int i=0;i<=N;i++)
                DP[i][0] = 1;
            for(int i=1;i<=N;i++){
                int value = coin[i];
                for(int j=1;j<=M;j++){
                    DP[i][j] = DP[i-1][j];
                    if(j >= value)
                        DP[i][j] += DP[i][j - value];
                }
            }
            bw.write(String.valueOf(DP[N][M]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
