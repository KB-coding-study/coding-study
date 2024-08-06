import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13459 {

    static int N, M;
    static char[][] map;
    static boolean[][][][] visited; // 빨강, 파랑 구슬의 visit 상태
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // Row
        M = Integer.parseInt(st.nextToken()); // Column
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rdr, rdc, blr, blc;
        rdr = rdc = blr = blc = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'R') {
                    rdr = i; rdc = j;
                }
                else if(map[i][j] == 'B') {
                    blr = i; blc = j;
                }
            }
        }

        System.out.println(process(rdr, rdc, blr, blc));
    }

    private static int process(int rdr, int rdc, int blr, int blc) {

        Queue<Turn> q = new LinkedList<>();
        int time = 1;

        q.add(new Turn(rdr, rdc, blr, blc));
        visited[rdr][rdc][blr][blc] = true;

        Marble nRed = null, nBlue = null;
        while(!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                Turn now = q.poll();

                // 4방으로 장난감을 기울여보자.
                for (int d = 0; d < 4; d++) {
                    // 빨간 구슬 이동
                    nRed = move(now.rdr, now.rdc, 0, d);
                    // 파랑 구슬 이동
                    nBlue = move(now.blr, now.blc, 0, d);

                    // 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
                    if(map[nBlue.r][nBlue.c] == 'O') continue;
                    // 빨간 구슬만 구멍에 빠질 경우
                    if(map[nRed.r][nRed.c] == 'O') return 1;

                    // 빨간 구슬과 파란 구슬이 같은 칸에 있을 경우
                    if (nRed.r == nBlue.r && nRed.c == nBlue.c) {
                        // 빨간 구슬이 더 많이 이동했을 경우
                        if(nRed.dist> nBlue.dist) {
                            // 이전 위치로
                            nRed.r -= dr[d];
                            nRed.c -= dc[d];
                        } else {
                            nBlue.r -= dr[d];
                            nBlue.c -= dc[d];
                        }
                    }

                    // 이미 시도해봤던 상태라면 pass
                    if(visited[nRed.r][nRed.c][nBlue.r][nBlue.c]) continue;

                    visited[nRed.r][nRed.c][nBlue.r][nBlue.c] = true;

                    // Queue에 추가
                    q.add(new Turn(nRed.r, nRed.c, nBlue.r, nBlue.c));
                }
            }

            // 10번 이하로 성공할 수 없다면
            if(++time > 10) return 0;
        }
        return 0;
    }

    private static Marble move(int r, int c, int dist, int d) {

        int rr = r, cc = c;
        // 다음 칸이 벽이 아니고, 현재 칸이 구멍이 아니라면 계속 이동
        while(map[rr + dr[d]][cc + dc[d]] != '#' && map[rr][cc] != 'O') {
            rr += dr[d];
            cc += dc[d];
            dist++;
        }

        return new Marble(rr, cc, dist);
    }

    static class Marble {
        int r, c, dist;

        public Marble(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

    }

    static class Turn {
        int rdr, rdc, blr, blc;

        public Turn(int rdr, int rdc, int blr, int blc) {
            this.rdr = rdr;
            this.rdc = rdc;
            this.blr = blr;
            this.blc = blc;
        }
    }
}