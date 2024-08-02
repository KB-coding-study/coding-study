import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static int[] oper;
    static int min = 1000000000;
    static int max = -1000000000;

    public static void f(int index, int cal) {
        if (index == num.length) {
            min = Math.min(min, cal);
            max = Math.max(max, cal);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                if (i == 0) {
                    f(index + 1, cal + num[index]);
                } else if (i == 1) {
                    f(index + 1, cal - num[index]);
                } else if (i == 2) {
                    f(index + 1, cal * num[index]);
                } else {
                    f(index + 1, cal / num[index]);
                }
                oper[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        for(int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        oper = new int[4];
        for (int i = 0; i < 4; i++)
            oper[i] = Integer.parseInt(st.nextToken());

        f(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }
}