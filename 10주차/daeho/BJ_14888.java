import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] num, cal;
    static int min, max;
    static List<int[]>  cals;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        num = new int[N];
        cals = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        cal = new int[N - 1];

        for(int i = 0; i < 4; i++){
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++){
                cal[count++] = i + 1;
            }
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        permutation(cal, new int[cal.length], new boolean[cal.length], 0,  cals);

        for(int[] cal : cals){
            cal(num, cal);
        }

        sb.append(max).append("\n").append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }

    static void cal(int[] num, int[] cal){
        int answer = num[0];
        for(int i = 0; i < cal.length; i++){
            switch (cal[i]){
                case 1:
                    answer += num[i + 1];
                    break;
                case 2:
                    answer -= num[i + 1];
                    break;
                case 3:
                    answer *= num[i + 1];
                    break;
                case 4:
                    if(answer < 0){
                        answer = (-1) * ((-answer) / num[i + 1]);
                    }
                    else{
                        answer /= num[i + 1];
                    }
                    break;
            }
        }
        max = Math.max(max, answer);
        min = Math.min(min , answer);
    }

    static void permutation(int[] arr, int[] out, boolean[] visited, int depth, List<int[]> list){
        if(depth == arr.length){
            list.add(out.clone());
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, list);
                visited[i] = false;
            }
        }
    }
}