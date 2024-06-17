import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int m, n, h;
    static int arr[][][];
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // 입력값 배열 삽입
        arr = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        // bfs 실행
        System.out.println(bfs());
    }
    static int bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int nowZ = temp[0];
            int nowY = temp[1];
            int nowX = temp[2];
            // 상하좌우앞뒤 탐색
            for (int i = 0; i < 6; i++) {
                int nextZ = nowZ + dz[i];
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 범위 안에 있다면
                if(nextZ >= 0 && nextY >= 0 && nextX >= 0 &&
                        nextZ < h && nextY < n && nextX < m) {
                    // 익지 않은 토마토가 있다면
                    if(arr[nextZ][nextY][nextX] == 0) {
                        queue.offer(new int[] {nextZ, nextY, nextX});
                        arr[nextZ][nextY][nextX] = arr[nowZ][nowY][nowX] + 1;
                    }
                }
            }
        }
        // 반환값 변수
        int value = 0;
        // 완성된 배열 탐색
        for (int i = 0; i <h; i++) {
            for (int j = 0; j <n; j++) {
                for (int k = 0; k < m; k++) {
                    // 익지않은 토마토가 있다면
                    if(arr[i][j][k] == 0) return -1;
                    value = Math.max(value, arr[i][j][k]);
                }
            }
        }
        // 최댓값이 1이라면 모든 토마토가 익은 상태로 입력된것
        if(value == 1) return 0;
        // 반환전 1 빼주기
        return value - 1;
    }
}