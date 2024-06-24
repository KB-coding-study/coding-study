import java.io.*;
import java.util.*;

public class BOJ_2606 {
    static int computerNum, pairNum;
    static int[][] link;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerNum = Integer.parseInt(br.readLine());
        pairNum = Integer.parseInt(br.readLine());
        link = new int[computerNum + 1][computerNum + 1];
        visited = new boolean[computerNum + 1];

        for (int i = 0; i < pairNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 인접행렬 사용
            link[x][y] = 1;
            link[y][x] = 1;
        }

        // -1 => 1번 컴퓨터 제외
        int result = setWarm(1) - 1;
        System.out.println(result);
    }

    public static int setWarm(int v) {
        visited[v] = true;
        int cnt = 1;

        for (int i = 1; i <= computerNum; i++) {
            if (link[v][i] == 1 && !visited[i]) {
                cnt += setWarm(i);
            }
        }
        return cnt;
    }
}
