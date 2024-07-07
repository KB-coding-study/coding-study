import java.io.*;

public class aaa {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] checked;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        checked = new boolean[N];
        count = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for(int i = 0; i < N; i++){
            DFS(i);
        }

        sb.append(String.valueOf(count)).append("\n");
        for(int i = 0; i < N; i++){
            if(checked[i])
                sb.append(String.valueOf(i + 1)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void DFS(int start) {
        visited[start] = true;
        if(!visited[arr[start]])
            DFS(arr[start]);
        else if(!checked[arr[start]]) {
            checked[arr[start]] = true;
            DFS(arr[start]);
            count++;
        }
        visited[start] = false;
    }
}