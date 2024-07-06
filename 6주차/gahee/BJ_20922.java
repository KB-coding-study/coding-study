
import java.io.*;
import java.util.*;

public class BJ_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setting = br.readLine().split(" ");
        int n = Integer.parseInt(setting[0]);
        int k = Integer.parseInt(setting[1]);
        int[] number = new int[n];
        String[] strNum = br.readLine().split(" ");
        for(int i=0; i<n ;i++) {
            number[i] = Integer.parseInt(strNum[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0, rt=0;
        for(int lt=0; lt<n; lt++){
            while(rt<n) {
                int tmp = number[rt];
                int count = map.getOrDefault(tmp, 0);
                if(count==k) {
                    break;
                }
                map.put(tmp, count+1);
                rt+=1;
            }
            
            result=Math.max(result, rt-lt);
            map.put(number[lt] , map.get(number[lt])-1);
        }
        System.out.println(result);


    }


}
