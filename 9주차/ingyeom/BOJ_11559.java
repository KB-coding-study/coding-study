import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[12][6];
        for(int i = 0; i < 12; i++){
            String s = br.readLine();
            for(int j = 0; j < 6; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int ans = 0;
        boolean flag = true;
        while(flag) {
            flag = false;
            boolean[][] visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (visited[i][j] || arr[i][j] == '.')
                        continue;

                    char color = arr[i][j];
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    Queue<int[]> result = new LinkedList<>();
                    result.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int[] next = new int[]{now[0] + d[k][0], now[1] + d[k][1]};

                            if (next[0] < 0 || next[0] >= 12 || next[1] < 0 || next[1] >= 6 || visited[next[0]][next[1]] || color != arr[next[0]][next[1]])
                                continue;

                            visited[next[0]][next[1]] = true;
                            q.add(new int[]{next[0], next[1]});
                            result.add(new int[]{next[0], next[1]});
                        }
                    }

                    if (result.size() >= 4) {
                        flag = true;
                        while(!result.isEmpty()) {
                            int[] temp = result.poll();
                            arr[temp[0]][temp[1]] = '.';
                        }
                    }
                }
            }
            if (flag)
                ans++;

            for (int j = 0; j < 6; j++) {
                Queue<Character> tmp = new LinkedList<>();
                for (int i = 0; i < 12; i++) {
                    if(arr[i][j] != '.'){
                        tmp.add(arr[i][j]);
                    }
                }

                for(int i = 0; i < 12 - tmp.size(); i++){
                    arr[i][j] = '.';
                }
                for(int i = 12 - tmp.size(); i < 12; i++){
                    arr[i][j] = tmp.poll();
                }
            }
        }
        System.out.println(ans);
    }
}