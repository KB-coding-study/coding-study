import java.util.*;
import java.io.*;

public class Main{
    static int n, m, result = 2500, empty = 0;
    static int[][] arr;
    static List<int[]> virus;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void f(int count, int index){
        if(count == m){
            Queue<int[]> q = new LinkedList<>();
            int[][] temp = new int[n + 2][n + 2];

            for(int i = 0; i < n + 2; i++){
                for(int j = 0; j < n + 2; j++)
                    temp[i][j] = -1;
            }

            for(int i = 0; i < virus.size(); i++){
                if(virus.get(i)[2] == 1){
                    q.add(new int[]{virus.get(i)[0], virus.get(i)[1]});
                    temp[virus.get(i)[0]][virus.get(i)[1]] = 0;
                }
            }

            int t = 0, c = 0;
            while(!q.isEmpty()){
                int[] now = q.poll();

                if(result <= t)
                    break;

                for(int i = 0; i < 4; i++){
                    int[] next = new int[]{now[0] + d[i][0], now[1] + d[i][1]};

                    if(arr[next[0]][next[1]] == 1 || temp[next[0]][next[1]] != -1)
                        continue;

                    temp[next[0]][next[1]] = temp[now[0]][now[1]] + 1;
                    q.add(next);

                    if(arr[next[0]][next[1]] == 0){
                        c++;
                        t = temp[next[0]][next[1]];
                    }
                }
            }

            if(c == empty)
                result = Math.min(result, t);
            return;
        }

        for(int i = index; i < virus.size(); i++){
            virus.get(i)[2] = 1;
            f(count + 1, i + 1);
            virus.get(i)[2] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 2][n + 2];
        for(int i = 0; i < n + 2; i++){
            arr[i][0] = 1;
            arr[i][n + 1] = 1;
            arr[0][i] = 1;
            arr[n + 1][i] = 1;
        }

        virus = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 0)
                    empty++;
                else if(arr[i][j] == 2)
                    virus.add(new int[]{i, j, 0});
            }
        }

        f(0, 0);

        if(result == 2500)
            result = -1;
        System.out.println(result);
    }
}