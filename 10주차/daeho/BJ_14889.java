import java.io.*;
import java.util.*;

public class Main{
    static List<int[]> list;
    static int N, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int sum = 0;
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }
        answer = sum;

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i;
        }

        combination(arr, new int[N / 2], 0, new boolean[N], 0);
        for(int[] com : list){
            soccer(com, sum);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void combination(int[] arr, int[] out, int start, boolean[] visited, int depth){
        if(depth == N / 2){
            list.add(out.clone());
            return;
        }
        for(int i = start; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                combination(arr, out, i + 1, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void soccer(int[] arr, int sum) {
        int totalSum1 = 0;
        int totalSum2 = 0;
        boolean[] check = new boolean[N];

        for (int i = 0; i < N / 2; i++) {
            check[arr[i]] = true;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (check[i] && check[j]) {
                    totalSum1 += map[i][j] + map[j][i];
                }
                else if (!check[i] && !check[j]) {
                    totalSum2 += map[i][j] + map[j][i];
                }
            }
        }

        answer = Math.min(answer,  Math.abs(totalSum1 - totalSum2));
    }

}