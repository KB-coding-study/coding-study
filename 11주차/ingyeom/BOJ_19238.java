import java.io.*;
import java.util.*;

class Point {
    public int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Move implements Comparable<Move> {
    public int y, x;
    public int cost;

    public Move(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }

    @Override
    public int compareTo(Move o) {
        if (this.cost != o.cost) return this.cost - o.cost;
        if (this.y != o.y) return this.y - o.y;
        return this.x - o.x;
    }
}

public class Main {
    static int N, M, FUEL;
    static boolean[][] map;
    static Point[][] Passengers;
    static PriorityQueue<Move> pq;
    static Queue<Move> q;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        FUEL = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];
        Passengers = new Point[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int startTaxiY = Integer.parseInt(st.nextToken());
        int startTaxiX = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());
            int destX = Integer.parseInt(st.nextToken());
            Passengers[startY][startX] = new Point(destY, destX);
        }

        while (M-- != 0) {
            Move passenger = findPassenger(startTaxiY, startTaxiX);
            if (passenger.x == 0) {
                System.out.println(-1);
                return;
            }
            FUEL -= passenger.cost;
            Move goal = goGoal(passenger.y, passenger.x);
            if (goal.x == 0) {
                System.out.println(-1);
                return;
            }
            FUEL -= goal.cost;
            FUEL += (goal.cost * 2);
            startTaxiY = goal.y;
            startTaxiX = goal.x;
        }
        System.out.println(FUEL);
    }

    static Move goGoal(int y, int x) {
        q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N + 1][N + 1];
        visit[y][x] = true;
        int goalY = Passengers[y][x].y;
        int goalX = Passengers[y][x].x;
        Passengers[y][x] = null;
        q.offer(new Move(y, x, 0));
        while (!q.isEmpty()) {
            Move cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];
                if (nextY > N || nextY <= 0 || nextX > N || nextX <= 0 || visit[nextY][nextX] || map[nextY][nextX])
                    continue;
                visit[nextY][nextX] = true;
                if (cur.cost + 1 > FUEL) break;
                Move temp = new Move(nextY, nextX, cur.cost + 1);
                if (nextY == goalY && nextX == goalX) {
                    return temp;
                }
                q.add(temp);
            }
        }
        return new Move(0, 0, 0);
    }

    static Move findPassenger(int y, int x) {
        pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[N + 1][N + 1];
        //승객을 찾기 시작하는 자리에 승객이 있으면 자기 위치 반환
        if (Passengers[y][x] != null) {
            return new Move(y, x, 0);
        }
        pq.offer(new Move(y, x, 0));
        Move value = new Move(0, 0, 0);

        while (!pq.isEmpty()) {
            Move cur = pq.poll();
            if (Passengers[cur.y][cur.x] != null) {
                return new Move(cur.y, cur.x, cur.cost);
            }
            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];
                if (nextY > N || nextY <= 0 || nextX > N || nextX <= 0 || visit[nextY][nextX] || map[nextY][nextX])
                    continue;
                visit[nextY][nextX] = true;
                if (cur.cost + 1 > FUEL) break;
                pq.add(new Move(nextY, nextX, cur.cost + 1));

            }
        }
        return value;
    }
}
