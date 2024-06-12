import java.io.*;
import java.util.*;


public class no5648 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0 ; i < N ; i++) {
            long inputNum = sc.nextLong();
            long inputNumReverse = 0;
            while(inputNum>0) {
                inputNumReverse = inputNumReverse*10 + inputNum%10;
                inputNum = inputNum/10;
            }
            arr[i] = inputNumReverse;
        }
        arr = Arrays.stream(arr).sorted().toArray();

        for(int i = 0 ; i < N ; i++) {
            System.out.println(arr[i]);
        }
    }
}
