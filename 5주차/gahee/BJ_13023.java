import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BJ_13023 {
    static boolean[] visited;
    static int n;
    static int m;
    static boolean flag = false;
    static List<List<Integer>> li = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        visited = new boolean[n];
        for(int i=0; i<n; i++){
            li.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split(" ");

            int from = Integer.parseInt(row[0]);
            int to = Integer.parseInt(row[1]);
            li.get(from).add(to);
            li.get(to).add(from);
        }

        for(int i=0; i<n; i++) {
            for(int j : li.get(i)) {
                visited[i] = true;
                dfs(j, 2);
                if (flag) {
                    System.out.println(1);
                    return;
                }
                visited = new boolean[n];
            }
        }
        System.out.println(0);
    }

    public static void dfs(int go, int count){
        visited[go] = true;
        if(count==5) {
            flag = true;
            return;
        }
        for(int i : li.get(go)) {
            if(!visited[i]) {
                dfs(i, count+1);
            }
        }
        visited[go] = false;
    }
}

