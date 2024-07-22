import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i < N+1 ; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            String str = br.readLine();
            int S = Integer.parseInt(str.split(" ")[0]);
            int E = Integer.parseInt(str.split(" ")[1]);
            if (isPalindrome(S,E)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
    public static boolean isPalindrome(int S, int E) {
        boolean palindrome = true;
        while(S<=E) {
            if(numArr[S]!=numArr[E]) {
                palindrome = false;
            }
            S+=1;
            E-=1;
        }

        return palindrome;
    }
}
