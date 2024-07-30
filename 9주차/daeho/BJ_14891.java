import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int arr[][] = new int[6][8];
        int rotation[] = new int[6];

        for(int i = 1; i <= 4; i++){
            String s = br.readLine();
            for(int j = 0; j < 8; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int save[] = new int[6];
            save[n] = k;

            for(int j = n; j <= 4; j++){
                if(arr[j][(10 - rotation[j]) % 8] != arr[j + 1][(14 - rotation[j + 1]) % 8]) {
                    save[j + 1] = save[j] * (-1);
                }
                else
                    break;
            }
            for(int j = n; j >= 1; j--){
                if(arr[j][(14 - rotation[j]) % 8] != arr[j - 1][(10 - rotation[j - 1]) % 8])
                    save[j - 1] = save[j] * (-1);
                else
                    break;
            }
            for(int j = 1; j <= 4; j++){
                rotation[j] = (8 + rotation[j] + save[j]) % 8;
            }
        }

        int result = 0;

        for(int i = 1; i <= 4; i++){
            if(arr[i][(8 - rotation[i]) % 8] == 1)
                result += pow(i);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int pow(int k){
        int p = 1;
        for(int i = 1; i < k; i++){
            p *= 2;
        }
        return p;
    }
}