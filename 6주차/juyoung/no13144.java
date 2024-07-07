import java.io.*;
import java.util.*;

public class no13144 {

    static int N;
    static int[] numArr;
    static Map<Integer, Integer> map;
    static Long answer = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        map = new HashMap<>();
        int right = 1 , left = 0;
        while(left<N) {
            if (!map.containsKey(numArr[right])) {
                answer += right-left;
                map.put(numArr[right],0);
                if (right<N){
                    right+=1;
                }
            } else {
                left+=1;
                map.remove(numArr[left]);
            }
        }
        System.out.println(answer);
    }
}
