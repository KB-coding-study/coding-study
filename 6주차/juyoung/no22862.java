import java.util.*;
import java.io.*;

public class no22862 {

    static int S, K, MAX = 0;
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        S = Integer.parseInt(str.split(" ")[0]);
        K = Integer.parseInt(str.split(" ")[1]);

        numArr = new int[S];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < S ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num%2 == 0) {
                numArr[i] = 1;
            } else {
                numArr[i] = -1;
            }
        }
        int right = 0 , left = 0;
        int len = 0, oddContain = 0;
        while(right<S) {
            if (numArr[right] == 1) {
                len+=1;
                if (len>MAX) {
                    MAX = len;
                }
                right+=1;
            } else {
                oddContain+=1;
                right+=1;
                while(oddContain>K) {
                    if (numArr[left]==-1) {
                        left+=1;
                        oddContain-=1;
                    } else if (numArr[left]==1) {
                        left+=1;
                        len-=1;
                    }
                }
            }
        }
        System.out.println(MAX);
    }
}
// 1 1 1 1 2 2 1 1 2 3 2
