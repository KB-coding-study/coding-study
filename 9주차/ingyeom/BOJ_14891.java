import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[4];
        for (int i = 0; i < 4; i++) {
            s[i] = br.readLine();
        }

        boolean[] check = new boolean[3];
        int[] index = new int[4];

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            for(int i = 0; i < 3; i++){
                if(s[i].charAt((index[i] + 2) % 8) == s[i + 1].charAt((index[i + 1] + 6) % 8)){
                    check[i] = true;
                    continue;
                }
                check[i] = false;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int d = -Integer.parseInt(st.nextToken());

            index[n] = (index[n] + d + 8) % 8;
            int temp = d;
            for(int i = n - 1; i >= 0; i--){
                if(check[i])
                    break;

                temp = -temp;
                index[i] = (index[i] + temp + 8) % 8;
            }

            temp = d;
            for(int i = n + 1; i < 4; i++){
                if(check[i - 1])
                    break;

                temp = -temp;
                index[i] = (index[i] + temp + 8) % 8;
            }
        }

        int result = 0;
        for(int i = 0; i < 4; i++){
            if(s[i].charAt(index[i]) == '1')
                result += (int) Math.pow(2, i);
        }
        System.out.println(result);
    }
}