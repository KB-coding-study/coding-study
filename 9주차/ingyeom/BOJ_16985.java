import java.io.*;
import java.util.*;

public class Main {
    static int[][][] cube = new int[7][7][7], cube2 = new int[7][7][7];
    static int[] order = new int[7];
    static boolean[] v = new boolean[7];
    static int[][] d = {{-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};
    static int result = 125;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int k = 1; k <= 5; k++) {
            for (int i = 1; i <= 5; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 5; j++) {
                    cube[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 큐브 판 순서 정하기
            // 각 판마다 회전
                // bfs
        setOrder(1);
        System.out.println(result == 125 ? -1 : result);
    }

    // 큐브 판 순서 정하기
    public static void setOrder(int index) {
        if (index == 6) {
            // 순서에 맞게 큐브 재설계
            for(int k = 1; k <= 5; k++) {
                for (int i = 1; i <= 5; i++) {
                    for(int j = 1; j <= 5; j++) {
                        cube2[k][i][j] = cube[order[k]][i][j];
                    }
                }
            }

            // 각 판마다 회전
            spin(1);
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (!v[i]) {
                v[i] = true;
                order[index] = i;
                setOrder(index + 1);
                v[i] = false;
            }
        }
    }

    public static void spin(int index) {
        if (index == 6) {
            // bfs
            if(cube2[1][1][1] == 1)
                bfs();
            return;
        }

        for(int k = 0; k < 4; k++) {
            int[][] temp = new int[7][7];
            for (int i = 1; i <= 5; i++) {
                for(int j = 1; j <= 5; j++) {
                    temp[j][5 - i + 1] = cube2[index][i][j];
                }
            }

            for (int i = 1; i <= 5; i++) {
                cube2[index][i] = Arrays.copyOf(temp[i], 7);
            }

            spin(index + 1);
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] v2 = new boolean[7][7][7];
        q.add(new int[] { 1, 1, 1, 0 });
        v2[1][1][1] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];
            int c = now[3];

            if(c >= result)
                return;

            if(x == 5 && y == 5 && z == 5){
                result = Math.min(result, c);
                return;
            }

            for(int i = 0; i < d.length; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                int nz = z + d[i][2];
                int nc = c + 1;

                if(v2[nx][ny][nz] || cube2[nx][ny][nz] == 0)
                    continue;

                v2[nx][ny][nz] = true;
                q.add(new int[] { nx, ny, nz, nc });
            }
        }
    }
}