package week11;

import java.io.*;
import java.util.*;

public class BOJ19238 {
    public static void main(String[] args) throws IOException {
        //✅ 입력 형식에 맞춰서 입력값을 받는다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        boolean[][] wall = new boolean[N+1][N+1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(reader.readLine());
            for (int c = 1; c <= N; c++) {
                wall[r][c] = (st.nextToken().equals("1"));
            }
        }

        //✅ 승객의 출발지와 도착지를 해시테이블에 저장한다.
        // Passenger 클래스는 시작 위치(Point)와 목적지(Point)를 가진다.
        st = new StringTokenizer(reader.readLine());
        Point taxi = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Map<Point, Passenger> passengers = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            Point from = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point to = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            passengers.put(from, new Passenger(from, to));
        }

        final int[] dr = { -1,  0,  1,  0 };
        final int[] dc = {  0, -1,  0,  1 };
        // Entry 클래스는 현재 위치와 이동 거리를 가진다.
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(new Entry(taxi, 0));
        //✅ 남아있는 승객이 있다면 반복문을 수행한다.
        for (int i = 0; i < M; i++) {
            //✅ BFS 알고리즘으로 현재 택시 위치로부터 승객까지의 최단거리를 계산한다.
            Passenger passenger = null;
            Point initialPoint = queue.peek().p;
            // 만약 현재 위치에 승객이 있다면 즉시 승객을 태운다.
            if (passengers.containsKey(initialPoint)) {
                passenger = passengers.get(initialPoint);
                queue.clear();
            }
            // 아니라면 BFS로 가장 가까운 승객을 탐색한다.
            int usage = 0;
            boolean[][] visited = prepareVisited(wall);
            while (!queue.isEmpty()) {
                Entry cur = queue.remove();
                if (cur.dist == fuel) break;
                // 이미 찾은 승객이 있고, 거리가 최소 이동 거리보다 크거나 같으면 탐색을 종료한다.
                if (passenger != null && usage <= cur.dist) break;

                for (int d = 0; d < 4; d++) {
                    Point next = new Point(cur.p.r + dr[d], cur.p.c + dc[d]);
                    if (next.inRange(N, N) && !visited[next.r][next.c]) {
                        visited[next.r][next.c] = true;
                        // 현재 위치에 승객이 있는지 확인한다.
                        if (passengers.containsKey(next)) {
                            Passenger newPassenger = passengers.get(next);
                            // 처음 발견한 승객이라면 passenger에 저장한다.
                            // 처음이 아니라면 이전 승객과 위치를 비교한다.
                            if (passenger == null) {
                                passenger = newPassenger;
                                usage += cur.dist + 1;
                            } else if (newPassenger.from.compareTo(passenger.from) < 0 && usage == cur.dist + 1) {
                                passenger = newPassenger;
                            }
                        } else {
                            queue.add(new Entry(next, cur.dist + 1));
                        }
                    }
                }
            }
            // 승객을 못 찾았다면 -1 출력.
            if (passenger == null) {
                System.out.println(-1);
                return;
            }
            fuel -= usage;
            usage = 0;
            queue.clear();
            queue.add(new Entry(passenger.from, 0));
            boolean arrived = false;
            visited = prepareVisited(wall);
            //✅ 최단거리를 기준으로 가장 높은 우선순위의 승객 위치로 택시를 이동시킨다.
            outer: while (!queue.isEmpty()) {
                Entry cur = queue.remove();
                if (cur.dist == fuel) break;

                for (int d = 0; d < 4; d++) {
                    Point next = new Point(cur.p.r + dr[d], cur.p.c + dc[d]);
                    if (next.inRange(N, N) && !visited[next.r][next.c]) {
                        visited[next.r][next.c] = true;
                        if (passenger.to.equals(next)) {
                            arrived = true;
                            usage = cur.dist + 1;
                            break outer;
                        } else {
                            queue.add(new Entry(next, cur.dist + 1));
                        }
                    }
                }
            }

            //✅ 연료가 충분하다면 BFS 알고리즘을 통해 승객을 도착지까지 이동시키고 연료를 보충받는다.
            if (arrived) {
                fuel += usage;
                queue.clear();
                queue.add(new Entry(passenger.to, 0));
                passengers.remove(passenger.from);
            } else {
                //✅ 승객 이동시키기에 실패한다면 -1를 출력한다.
                System.out.println(-1);
                return;
            }
        }
        //✅ 모든 승객 이동시키기에 성공한다면 남은 연료를 출력한다.
        System.out.println(fuel);
    }

    static boolean[][] prepareVisited(boolean[][] wall) {
        boolean[][] result = new boolean[wall.length][wall[0].length];
        for (int r = 0; r < wall.length; r++) {
            System.arraycopy(wall[r], 0, result[r], 0, result[r].length);
        }
        return result;
    }

    static class Entry {
        Point p;
        int dist;

        public Entry(Point p, int dist) {
            this.p = p;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "E" + p + ":" + dist;
        }
    }

    static class Passenger {
        // 디버깅용 필드
        static int seq = 1;
        int id;
        Point from;
        Point to;

        public Passenger(Point from, Point to) {
            this.id = seq++;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "P" + id + ":" + from + "->" + to;
        }
    }

    static class Point implements Comparable<Point> {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean inRange(int n, int m) {
            return r > 0 && r <= n && c > 0 && c <= m;
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point)o;
                return this.r == p.r && this.c == p.c;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.r, this.c);
        }

        @Override
        public int compareTo(Point p) {
            if (this.r == p.r) {
                return this.c - p.c;
            } else {
                return this.r - p.r;
            }
        }
    }
}
/* 풀이2

import java.util.*;
        import java.io.*;

class Taxi {
    int wall;
    Integer goal [];
    Taxi(int wall,Integer goal[]) {
        this.wall=wall;
        this.goal=goal;
    }
}

public class Main{
    static Taxi map[][];
    static int taxiY;
    static int taxiX;
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        map=new Taxi[N][N];

        //해당 좌표의 벽과
        //손님이 없다면 null
        //손님이 있다면 목적지 좌표를 넣음
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j]=new Taxi(0,null);
                map[i][j].wall = Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        taxiY=Integer.parseInt(st.nextToken())-1;
        taxiX=Integer.parseInt(st.nextToken())-1;
        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            int personY=Integer.parseInt(st.nextToken());
            int personX=Integer.parseInt(st.nextToken());
            int goalY=Integer.parseInt(st.nextToken());
            int goalX=Integer.parseInt(st.nextToken());
            map[personY-1][personX-1].goal= new Integer[] {goalY-1,goalX-1};
        }


        for(int i=0;i<M;i++) {
            ///택시의 좌표에서 bfs수행
            Integer temp[] = bfs1();

            int personY=temp[0];
            int personX=temp[1];
            int distance1=temp[2];
            int goalY=temp[3];
            int goalX=temp[4];
            fuel -= distance1;

            //택시는 손님의 위치가 됨
            taxiY=personY;
            taxiX=personX;
            //연료가 0미만이면 0출력
            if(fuel<0) {
                System.out.println(-1);
                System.exit(0);
            }

            //손님의 위치에서, 손님의 목적지 까지 bfs
            int distance2 = bfs2(personY,personX,goalY,goalX);
            fuel-=distance2;

            //연료가 0미만이면 0출력
            if(fuel<0) {
                System.out.println(-1);
                System.exit(0);
            }
            //연료를 더해주고, 택시의 위치를 조정
            fuel += (distance2*2);
            taxiY=goalY;
            taxiX=goalX;
        }

        //연료 출력
        System.out.println(fuel);


    }
    //손님의 위치까지 가는 bfs.
    public static Integer[] bfs1() {
        Queue<Integer[]> queue=new LinkedList<>();
        queue.add(new Integer[] {taxiY,taxiX,0});
        boolean visited[][]=new boolean[map.length][map.length];

        visited[taxiY][taxiX] = true;

        ArrayList<Integer[]> list=new ArrayList<>();

        while(!queue.isEmpty()) {
            Integer temp[]= queue.poll();
            int nowY=temp[0];
            int nowX=temp[1];
            int count = temp[2];
            //해당 좌표에 목적지가 있다면 list에 넣음
            if(map[nowY][nowX].goal!=null)
                list.add( new Integer[] {nowY,nowX,count});

            for(int i=0;i<4;i++) {
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(nextY<0||nextX<0||nextY>=map.length||nextX>=map.length)
                    continue;
                if(map[nextY][nextX].wall==1||visited[nextY][nextX]==true)
                    continue;

                visited[nextY][nextX] = true;
                queue.add(new Integer[] {nextY,nextX,count+1});
            }

        }
        //list size가 0이면 벽으로 가로막혀 손님의 위치까지 가지 못한 것. -1출력
        if(list.size()==0) {
            System.out.println(-1);
            System.exit(0);
        }

        //손님들의 위치를 정렬
        Collections.sort(list,new Comparator<>() {
            @Override
            public int compare(Integer n1[],Integer n2[]) {
                if(n1[2]>n2[2]) return 1;
                else if(n1[2]==n2[2]) {
                    if(n1[0]>n2[0]) return 1;
                    else if(n1[0]==n2[0]) {
                        if(n1[1]>n2[1]) return 1;
                    }
                }

                return -1;
            }
        });

        //손님의 위치, 손님의 목적지의 위치를 반환하고
        //해당 좌표의 손님의 목적지를 null로 바꿈
        int y=list.get(0)[0];
        int x=list.get(0)[1];
        int count = list.get(0)[2];
        int goalY=map[y][x].goal[0];
        int goalX=map[y][x].goal[1];
        map[y][x].goal = null;

        return new Integer[] {y,x,count,goalY,goalX};


    }


    //손님의 위치, 목적지의 위치가 주어졌을 때의 bfs
    public static int bfs2(int nowY,int nowX,int goalY,int goalX) {

        Queue<Integer[]> queue=new LinkedList<>();
        boolean visited[][]=new boolean[map.length][map.length];
        visited[nowY][nowX] = true;
        queue.add(new Integer[] {nowY,nowX,0});

        while(!queue.isEmpty()) {
            Integer temp[]=queue.poll();
            int Y=temp[0];
            int X=temp[1];
            int count = temp[2];
            //목적지를 찾았다면 해당 좌표까지의 거리를 return
            if(Y==goalY&&X==goalX)
                return count;

            for(int i=0;i<4;i++) {
                int nextY=Y+dy[i];
                int nextX=X+dx[i];
                if(nextY<0||nextX<0||nextY>=map.length||nextX>=map.length)
                    continue;
                if(map[nextY][nextX].wall==1||visited[nextY][nextX])
                    continue;

                visited[nextY][nextX] = true;
                queue.add(new Integer[] {nextY,nextX,count+1});
            }

        }

        //queue가 다 비어도 목적지를 못찾았다면
        //벽으로 가로막혀 목적지로 갈 수 없는 것임. -1출력
        System.out.println(-1);
        System.exit(0);

        return 0;
    }

}
