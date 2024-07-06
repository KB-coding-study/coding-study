package TwoPointers;
 
import java.io.*;;
import java.util.*;;
 
public class no20922 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, K;
    static int A[];
    static int possible[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = atoi(st.nextToken());
        K = atoi(st.nextToken());
 
        A = new int[N + 1];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }
 
        pro();
    }
 
    static void pro() {
        int e = 0, len = 0;
 
        for (int s = 1; s <= N; s++) {
            if(possible[A[s-1]] > 0) possible[A[s-1]]--;
 
            while(e+1 <= N && possible[A[e+1]] < K){
                possible[A[++e]]++;
            }
 
            len = Math.max(len, e - s + 1);
        }
 
        System.out.println(len);
    }
}
