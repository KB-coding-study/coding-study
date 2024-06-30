
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BJ_11724 {
    static boolean visited[] ;
    static List<List<Integer>> connectList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[]  str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            connectList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++ ) {
            String[] st = br.readLine().split(" ");
            int start = Integer.parseInt(st[0])-1;
            int end = Integer.parseInt(st[1])-1;
            connectList.get(start).add(end);
            connectList.get(end).add(start);
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);


    }
    public static void dfs(int i) {
        visited[i] = true;
        for(int next : connectList.get(i)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

}

