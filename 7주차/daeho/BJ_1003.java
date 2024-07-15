import java.io.*;

public class Main {
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        result = new int[41][2];

        result[0][0] = 1;
        result[0][1] = 0;
        result[1][0] = 0;
        result[1][1] = 1;

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            for(int j = 2; j <= N; j++){
                if(result[j][0] == 0 && result[j][1] == 0) {
                    result[j][0] = result[j - 1][0] + result[j - 2][0];
                    result[j][1] = result[j - 1][1] + result[j - 2][1];
                }
            }
            sb.append(result[N][0]).append(" ").append(result[N][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
