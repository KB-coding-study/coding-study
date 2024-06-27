package bongJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 {

    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        visit = new boolean[n + 1];

        // 관계 입력 (양방향)
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i < n; i++) {
            visit[i] = true;
            dfs(i,0);
            visit[i] = false;
            if(result == 1) {
                break;
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int count) {
        if(count >= 4) {
            result = 1;
            return;
        }

        for(int i : list[x]) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i,count + 1);
                visit[i] = false;
            }
        }
    }
}