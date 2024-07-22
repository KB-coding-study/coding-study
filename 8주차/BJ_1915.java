import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][m];
        int[][] arr = new int[n][m];
        int max = 0;

        for(int i = 0 ; i  < n; i++){
            String s = br.readLine();
            for(int j = 0 ; j  < m; j++){
                arr[i][j] = s.charAt(j) == '0' ? 0 : 1;
            }
        }

        for(int i = 0; i < m; i++){
            dp[0][i] = arr[0][i];
        }
        for(int i = 0 ; i < n; i++){
            dp[i][0] = arr[i][0];
        }


        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(arr[i][j] == 0)
                    continue;
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                max = Math.max(dp[i][j], max);
            }
        }

        bw.write(String.valueOf(max * max));
        bw.flush();
        bw.close();
    }

}