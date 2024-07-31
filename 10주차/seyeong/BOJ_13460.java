import java.util.*;


public class Main{

    static char[][] req = new char[11][11];
    static boolean[][][][] check = new boolean[11][11][11][11];
    static int N,M;
    static int hy,hx;
    static Marble red;
    static Marble blue;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static Marble moveMarble(Marble marble, int dir){
        int y = marble.y;
        int x = marble.x;

        while(req[y+dy[dir]][x+dx[dir]] != '#'){
            y += dy[dir];
            x += dx[dir];
            if(y == hy && x == hx) break;
        }

        return new Marble(y,x);
    }

    static int bfs(){
        check[blue.y][blue.x][red.y][red.x] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(blue,red,0));

        while(!queue.isEmpty()){
            Pair marbles = queue.poll();

            // 10번 이하로 움직여서 구슬을 빼낼 수 없으면 카운트 제외
            if(marbles.cnt>10) return -1;

            // 빨간 구슬이 빠질 경우 res에 넣기
            if(marbles.red.y==hy && marbles.red.x==hx) return marbles.cnt;

            for(int i=0;i<4;i++){
                Marble new_blue = moveMarble(marbles.blue,i);
                Marble new_red = moveMarble(marbles.red,i);

                // 파란 구슬이 빠질 경우 무조건 실패
                if(new_blue.y==hy && new_blue.x==hx) continue;

                // 두 구슬의 위치가 같은 경우 재조정
                if(new_blue.y== new_red.y && new_blue.x== new_red.x){
                    switch (i){
                        // 오른쪽
                        case 0:
                            //  움직이기 이전 x값이 더 큰 구슬이 현재 위치,
                            // x값이 더 작은 구슬이 x-1만큼
                            if(marbles.blue.x > marbles.red.x) new_red.x--;
                            else new_blue.x--;
                            break;
                        // 아래쪽
                        case 1:
                            //  움직이기 이전 y값이 더 큰 구슬이 현재 위치,
                            // y값이 더 작은 구슬이 y-1만큼
                            if(marbles.blue.y > marbles.red.y) new_red.y--;
                            else new_blue.y--;
                            break;
                        // 왼쪽
                        case 2:
                            //  움직이기 이전 x값이 더 작은 구슬이 현재 위치,
                            // x값이 더 큰 구슬이 x+1만큼
                            if(marbles.blue.x > marbles.red.x) new_blue.x++;
                            else new_red.x++;
                            break;
                        // 위쪽
                        case 3:
                            //  움직이기 이전 y값이 더 작은 구슬이 현재 위치,
                            // y값이 더 큰 구슬이 y+1만큼
                            if(marbles.blue.y > marbles.red.y) new_blue.y++;
                            else new_red.y++;
                            break;
                    }
                }

                // 이미 굴린 적 없는 포지션이었다면 이어서 구슬 굴리기
                if(!check[new_blue.y][new_blue.x][new_red.y][new_red.x]){
                    check[new_blue.y][new_blue.x][new_red.y][new_red.x] = true;
                    queue.add(new Pair(new_blue,new_red, marbles.cnt+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String str = br.readLine();

            for(int j=0;j<M;j++){
                req[i][j] = str.charAt(j);
                if(req[i][j]=='B') blue = new Marble(i,j);
                else if(req[i][j]=='R') red = new Marble(i,j);
                else if(req[i][j]=='O'){
                    hy = i;
                    hx = j;
                }
            }
        }

        int res = bfs();
        System.out.println(res);
    }
}

class Marble{
    int y;
    int x;

    public Marble(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Pair{
    Marble blue;
    Marble red;
    int cnt;

    public Pair(Marble blue, Marble red, int cnt){
        this.blue = blue;
        this.red = red;
        this.cnt = cnt;
    }
}
