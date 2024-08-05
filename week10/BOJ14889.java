package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n;
    static int min = 101;
    static int[][] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];


        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(new ArrayList<Integer>(), 1, n / 2);

        System.out.println(min);
    }

    // 조합 생성
    public static void combi(ArrayList<Integer> start, int index, int count) {
        if(count == 0) {
            ArrayList<Integer> link = new ArrayList<>();

            for(int i = 1; i <= n; i++) {
                if(!start.contains(i)) {
                    link.add(i);
                }
            }
            solve(start,link);
            return;
        }

        // start 팀 조합 생성
        for(int i = index; i <= n; i++) {
            start.add(i);
            combi(start, i + 1, count - 1);
            start.remove(start.size() - 1);
        }
    }

    // 조합별 능력치 차이 최솟값 찾기
    public static void solve(ArrayList<Integer> start, ArrayList<Integer> link) {
        int startSum = 0;
        int linkSum = 0;

        for(int i = 0; i < start.size() - 1; i++) {
            for(int j = i + 1; j < start.size(); j++) {
                int x = start.get(i);
                int y = start.get(j);
                startSum += arr[x][y] + arr[y][x];
            }
        }

        for(int i = 0; i < link.size() - 1; i++) {
            for(int j = i + 1; j < link.size(); j++) {
                int x = link.get(i);
                int y = link.get(j);
                linkSum += arr[x][y] + arr[y][x];
            }
        }

        int result = Math.abs(startSum - linkSum);
        min = Math.min(min, result);
    }
}
