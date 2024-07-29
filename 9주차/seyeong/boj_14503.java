import java.util.*;

public class Main {

    static int N, M, r, c, d;
    static int[][] arr;
    static int count = 1; //시작 지점은 항상 청소되어 있지 않음
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
            	arr[i][j] = scan.nextInt();
            }
        }

        clean(r, c, d);
        System.out.println(count);
    }

    public static void clean(int x, int y, int dir) {

    	arr[x][y] = -1;

        for(int i = 0; i < 4; i++) {
        	dir = (dir+3)%4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(arr[nx][ny] == 0) {
                    count++;
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4; //반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] != 1) {
        	clean(bx, by, dir); //후진이니까 바라보는 방향은 유지
        }
    }
}
출처: https://yeons4every.tistory.com/161 [나누는 개발 공부:티스토리]