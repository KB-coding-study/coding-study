import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class BJ_2644 {

    static int n;
    static int[][] map;
    static int start;
    static int end;
    static int distance[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String [] targets = br.readLine().split(" ");
        start = Integer.parseInt(targets[0])-1;
        end = Integer.parseInt(targets[1])-1;
        distance = new int[n];
        map = new int[n][n];

        int connect = Integer.parseInt(br.readLine());
        for(int i=0; i<connect; i++) {
            String[] c = br.readLine().split(" ");
            int s = Integer.parseInt(c[0])-1;
            int e = Integer.parseInt(c[1])-1;
            map[s][e] = 1;
            map[e][s] = 1;
        }
        dfs(start);
        System.out.println(distance[end] == 0 ? -1 : distance[end]);


    }
    private static void dfs(int go) {
        if (go == end) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (map[go][i] == 1 && distance[i] == 0) {
                distance[i] = distance[go] + 1;
                dfs(i);
            }
        }
    }
}
