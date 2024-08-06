package week11;

import java.io.*;
import java.util.*;

public class BOJ13459 {
    public static void main(String[] args) throws IOException {
        //✅ 입력 형식에 맞춰서 입력값을 받는다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        final int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());
        boolean[][] wall = new boolean[N][M];
        //✅ 빨간 구슬과 파란 구슬의 위치를 저장한다.
        Point red = null, blue = null, out = null;
        for (int r = 0; r < N; r++) {
            char[] line = reader.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                switch (line[c]) {
                    case '#': wall[r][c] = true; break;
                    case 'R': red = new Point(r, c); break;
                    case 'B': blue = new Point(r, c); break;
                    case 'O': out = new Point(r, c); break;
                }
            }
        }

        //✅ 두 구슬의 초기 위치를 시작으로 BFS 알고리즘을 수행한다.
        Queue<Entry> queue = new ArrayDeque<>();
        Set<Entry> visited = new HashSet<>();
        queue.add(new Entry(red, blue, 0));
        visited.add(queue.peek());

        final int[] dr = { -1,  0,  1,  0 };
        final int[] dc = {  0, -1,  0,  1 };
        while (!queue.isEmpty()) {
            Entry current = queue.remove();
            //✅ 움직임 횟수가 10을 초과하면 반복문을 종료한다.
            if (current.distance == 10) continue;
            red = current.red;
            blue = current.blue;

            for (int d = 0; d < 4; d++) {
                //✅ 기울이는 방향에 따른 두 구슬의 다음 위치를 구한다.
                // 빨간공 움직이기
                Point nextRed = new Point(red.r + dr[d], red.c + dc[d]);
                boolean isRedOut = false;
                while (nextRed.valid(wall)) {
                    if (nextRed.equals(out)) {
                        nextRed.r += dr[d];
                        nextRed.c += dc[d];
                        isRedOut = true;
                        break;
                    }
                    nextRed.r += dr[d];
                    nextRed.c += dc[d];
                }
                nextRed.r -= dr[d];
                nextRed.c -= dc[d];

                // 파란공 움직이기
                Point nextBlue = new Point(blue.r + dr[d], blue.c + dc[d]);
                boolean isBlueOut = false;
                while (nextBlue.valid(wall)) {
                    if (nextBlue.equals(out)) {
                        nextBlue.r += dr[d];
                        nextBlue.c += dc[d];
                        isBlueOut = true;
                        break;
                    }
                    nextBlue.r += dr[d];
                    nextBlue.c += dc[d];
                }
                nextBlue.r -= dr[d];
                nextBlue.c -= dc[d];

                //✅ 두 구슬의 다음 위치가 동일할 때, 이동 횟수가 더 많은 구슬의 위치를 한 칸 뒤로 이동한다.
                if (nextRed.equals(nextBlue)) {
                    if (red.getDistance(nextRed) > blue.getDistance(nextBlue)) {
                        nextRed.r -= dr[d];
                        nextRed.c -= dc[d];
                    } else {
                        nextBlue.r -= dr[d];
                        nextBlue.c -= dc[d];
                    }
                }

                //✅ 파란 구슬의 다음 위치가 구멍이라면, 다른 방향으로 기울이기를 시도한다.
                //✅ 두 구슬의 다음 위치가 이미 방문했던 위치라면, 다른 방향으로 기울이기를 시도한다.
                Entry next = new Entry(nextRed, nextBlue, current.distance+1);
                if (isRedOut && !isBlueOut) {
                    //✅ 성공 여부에 따라서 1 또는 0을 출력한다.
                    System.out.println(1);
                    return;
                } else if (!isBlueOut && !visited.contains(next)) {
                    queue.add(next);
                    //✅ 두 구슬의 다음 위치를 방문했다고 표시한다.
                    visited.add(next);
                }
            }
        }
        //✅ 성공 여부에 따라서 1 또는 0을 출력한다.
        System.out.println(0);
    }

    static class Entry {
        Point red;
        Point blue;
        int distance;

        public Entry(Point red, Point blue, int distance) {
            this.red = red;
            this.blue = blue;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Entry) {
                Entry e = (Entry)o;
                return red.equals(e.red) && blue.equals(e.blue);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(red, blue);
        }

        @Override
        public String toString() {
            return "E{Red:" + red + ",Blue:" + blue + "}";
        }

    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean valid(boolean[][] wall) {
            return !wall[r][c];
        }

        public int getDistance(Point o) {
            return Math.abs(r - o.r) + Math.abs(c - o.c);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point)o;
                return r == p.r && c == p.c;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + ")";
        }
    }
}