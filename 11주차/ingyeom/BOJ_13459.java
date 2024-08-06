import java.util.*;
import java.io.*;

public class Main {
    static int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int n, m;
    static char[][] arr;
    static int[][] ball = new int[2][2];

    public static void move(int b1, int direct, int b2){
        while(true){
            int[] next = {ball[b1][0] + d[direct][0], ball[b1][1] + d[direct][1]};

            if(arr[next[0]][next[1]] == '#')
                break;
            if(next[0] == ball[b2][0] && next[1] == ball[b2][1])
                break;
            if(arr[next[0]][next[1]] == 'O'){
                ball[b1][0] = 0;
                ball[b1][1] = 0;
                break;
            }

            ball[b1][0] = next[0];
            ball[b1][1] = next[1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = temp.charAt(j);

                if(arr[i][j] == 'R'){
                    ball[0][0] = i;
                    ball[0][1] = j;
                    arr[i][j] = '.';
                }
                else if(arr[i][j] == 'B'){
                    ball[1][0] = i;
                    ball[1][1] = j;
                    arr[i][j] = '.';
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ball[0][0], ball[0][1], ball[1][0], ball[1][1], -1, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            ball[0][0] = now[0];
            ball[0][1] = now[1];
            ball[1][0] = now[2];
            ball[1][1] = now[3];

            if(now[5] >= 10)
                continue;

            for(int i = 0; i < 4; i++){
                if(now[4] % 2 == i % 2)
                    continue;

                boolean check = false;

                move(0, i, 1);
                if(ball[0][0] == 0 && ball[0][1] == 0)
                    check = true;

                move(1, i, 0);
                if (ball[1][0] == 0 && ball[1][1] == 0) {
                    ball[0][0] = now[0];
                    ball[0][1] = now[1];
                    ball[1][0] = now[2];
                    ball[1][1] = now[3];
                    continue;
                }

                if (!check) {
                    move(0, i, 1);
                    if(ball[0][0] == 0 && ball[0][1] == 0)
                        check = true;
                }

                if(check){
                    System.out.println(1);
                    return;
                }

                if (ball[0][0] != now[0] || ball[0][1] != now[1] || ball[1][0] != now[2] || ball[1][1] != now[3]) {
                    q.add(new int[]{ball[0][0], ball[0][1], ball[1][0], ball[1][1], i, now[5] + 1});
                    ball[0][0] = now[0];
                    ball[0][1] = now[1];
                    ball[1][0] = now[2];
                    ball[1][1] = now[3];
                }
            }
        }
        System.out.println(0);
    }
}