import java.io.*;
import java.util.*;

public class Main {
    static int n, result = 40000;
    static int[][] s;
    static List<Set<Integer>> set = new ArrayList<>();
    static int[] score = new int[2];

    public static void push(int k, int type) {
        if(set.get(type).contains(k))
            return;

        for (int temp : set.get(type)) {
            score[type] += s[temp][k];
            score[type] += s[k][temp];
        }
        set.get(type).add(k);
    }

    public static void pop(int k, int type) {
        if(!set.get(type).contains(k))
            return;

        set.get(type).remove(k);
        for (int temp : set.get(type)) {
            score[type] -= s[temp][k];
            score[type] -= s[k][temp];
        }
    }

    public static void f(int index) {
        if (set.get(0).size() == n / 2) {
            result = Math.min(result, Math.abs(score[0] - score[1]));
            return;
        }

        for (int i = index + 1; i <= n; i++) {
            push(i, 0);
            pop(i, 1);
            f(i);
            pop(i, 0);
            push(i, 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set.add(new HashSet<>());
        set.add(new HashSet<>());

        n = Integer.parseInt(br.readLine());
        s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                s[i][j] = Integer.parseInt(st.nextToken());

            push(i, 1);
        }

        f(0);
        System.out.println(result);
    }
}