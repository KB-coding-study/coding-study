import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dp0 = new int[41];
        dp0[0] = 1; dp0[1] = 0;
        int[] dp1 = new int[41];
        dp1[0] = 0; dp1[1] = 1;

        for(int i = 2; i < 41; i++){
            dp0[i] = dp0[i-1] + dp0[i-2];
            dp1[i] = dp1[i-1] + dp1[i-2];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp0[n] + " " + dp1[n] + "\n");
            bw.flush();
        }
    }
}