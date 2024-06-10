package codingtest;

import java.io.*;
import java.util.*;

public class no1021 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static LinkedList<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] temp = new int[M];
        for(int i = 0 ; i < M ; i++)
            temp[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++)
            q.add(i);

        for(int i = 0 ; i < M ; i++) {

            if(check(temp[i])) {
                while(temp[i]!=q.get(0)) {
                    q.addLast(q.pollFirst());
                    count++;
                }
            }else {
                while(temp[i]!=q.get(0)) {
                    q.addFirst(q.pollLast());
                    count++;
                }
            }

            q.poll();
        }


        System.out.println(count);

    }
    public static boolean check(int a) {

        for(int i = 0 ; i <= q.size()/2 ; i++) {
            if(a == q.get(i))
                return true;
        }

        return false;
    }

}