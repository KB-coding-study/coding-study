import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setting = br.readLine().split(" ");
        int n = Integer.parseInt(setting[0]);
        int m = Integer.parseInt(setting[1]);

        int sum[] = new int[n+1];
        String[] num = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(num[i-1]);
        }
        int start = 0;
        int result = 0;
        for(int i=1; i<=n; i++) {
            while(i>start) {
                if(sum[i] - sum[start] > m) {
                    start+=1;
                    continue;
                }
                else if(sum[i] - sum[start] == m) {
                    result += 1;
                }
                break;
            }
        }
        System.out.println(result);
    }
}
