import java.io.*;

class BJ_11559 {
    static int dx[] = new int[] {-1,1,0,0};
    static int dy[] = new int[] {0,0,-1,1};
    static char[][] board = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                board[i][j] = line[j];
            }
        }
        boolean flag = true;
        int round =0;
        boolean shot = false;
        while(flag) {
            flag = false;
            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    if(board[i][j]!='.' && !visited[i][j]) {
                        if(dfs(i, j, board[i][j], 1) >=4) {
                            flag = true;
                            shot = true;
                            remove(i,j, board[i][j]);
                        }
                    }
                }
            }
            goDown();
            if(!shot) {
                break;
            }
            if(flag) {
                round +=1;
            }
            visited = new boolean[12][6];
        }
        System.out.println(round);
    }

    public static void remove(int x, int y, char target){
        board[x][y] = 'x';
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<12 && 0<=ny && ny<6
                    && board[nx][ny] == target) {
                remove(nx, ny, target);
            }
        }
    }

    public static void goDown()
    {
        for(int i=0; i<6; i++) {
            for(int j=11; j>0; j--) {
                int count=0;
                if(board[j][i]=='x') {
                    count+=1;
                    while(j-count>=0 && board[j-count][i]=='x'){
                        count+=1;
                    }
                    for(int t=0; t<count; t++) {
                        for(int row=j; row>0; row--) {
                            board[row][i] = board[row-1][i];
                        }
                        board[0][i] = '.';
                    }
                }
            }
        }
    }
    public static int dfs(int x, int y, char target, int count) {
        int targetCount = count;
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<12 && 0<=ny && ny<6
                    && board[nx][ny] == target
                    && !visited[nx][ny]) {
                targetCount = dfs(nx, ny, target, targetCount+1);
            }
        }
        return targetCount;
    }
}
