import java.util.*;
import java.io.*;

public class no2531 {

    static int N, d, k, c, MAX;
    static int[] numArr;
    static Map<Integer, Integer> sushiMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        d = Integer.parseInt(str.split(" ")[1]);
        k = Integer.parseInt(str.split(" ")[2]);
        c = Integer.parseInt(str.split(" ")[3]);

        numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        sushiMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            sushiMap.put(numArr[i], sushiMap.getOrDefault(numArr[i], 0) + 1);
        }
        sushiMap.put(c, sushiMap.getOrDefault(c, 0) + 1);
        MAX = sushiMap.size();
        int left = 0, right = k;
        while (left < N) {
            int countLeft = sushiMap.getOrDefault(numArr[left], 0);
            if (countLeft > 1) {
                sushiMap.put(numArr[left], countLeft - 1);
            } else {
                sushiMap.remove(numArr[left]);
            }
            sushiMap.put(numArr[right % N], sushiMap.getOrDefault(numArr[right % N], 0) + 1);
            left += 1;
            right += 1;
            if (MAX < sushiMap.size()) {
                MAX = sushiMap.size();
            }
        }
        System.out.println(MAX);
    }
}
