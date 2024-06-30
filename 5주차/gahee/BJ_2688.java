import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BJ_2688 {

    static boolean[] check;
    static boolean[] finish;
    static int[] numbers;

    static List<Integer> resultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n+1];
        for(int i=1; i<=n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        check = new boolean[n+1];
        finish = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            if(!check[i]) {
                dfs(i);
            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.size());
        for(int i: resultList) {
            System.out.println(i);
        }

    }
    static void dfs(int next) {
        check[next] = true;
        int go = numbers[next];

        if(!check[go]) {
            dfs(go);
        }
        else{
            if(!finish[go]) {
                for(int i=go; i!=next; i=numbers[i]) {
                    resultList.add(i);
                }
                resultList.add(next);
            }
        }
        finish[next] = true;
    }
}
