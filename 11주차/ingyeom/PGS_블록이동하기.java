import java.util.*;

class Solution {
    static class Node {
        int x1;
        int y1;
        int x2;
        int y2;
        int dir;
        int cnt;

        public Node(int x1, int y1, int x2, int y2, int dir, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    static int[][] vector = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static int len;
    static int[][] board;
    static boolean[][][] visit;
    static Queue<Node> queue;

    private static int bfs() {
        queue = new LinkedList<>();
        visit = new boolean[len][len][2];

        addQueue(0, 0, 0, 1, 0, 0);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if((node.x1 == len - 1 && node.y1 == len - 1) || (node.x2 == len - 1 && node.y2 == len - 1)) {
                return node.cnt;
            }

            for(int k = 0; k < 4; k++) {
                int nx1 = node.x1 + vector[k][0];
                int ny1 = node.y1 + vector[k][1];
                int nx2 = node.x2 + vector[k][0];
                int ny2 = node.y2 + vector[k][1];

                if(outBound(nx1, ny1, nx2, ny2)) {
                    continue;
                }

                if(visited(nx1, ny1, nx2, ny2, node.dir)) {
                    continue;
                }

                addQueue(nx1, ny1, nx2, ny2, node.dir, node.cnt + 1);
            }

            if(node.dir == 0) {
                if(!outBound(node.x1 - 1, node.y1, node.x2 - 1, node.y2)) {
                    if(!visited(node.x1, node.y1, node.x1 - 1, node.y1, 1)) {
                        addQueue(node.x1, node.y1, node.x1 - 1, node.y1, 1, node.cnt + 1);
                    }

                    if(!visited(node.x2, node.y2, node.x2 - 1, node.y2, 1)) {
                        addQueue(node.x2, node.y2, node.x2 - 1, node.y2, 1, node.cnt + 1);
                    }
                }

                if(!outBound(node.x1 + 1, node.y1, node.x2 + 1, node.y2)) {
                    if(!visited(node.x1, node.y1, node.x1 + 1, node.y1, 1)) {
                        addQueue(node.x1, node.y1, node.x1 + 1, node.y1, 1, node.cnt + 1);
                    }

                    if(!visited(node.x2, node.y2, node.x2 + 1, node.y2, 1)) {
                        addQueue(node.x2, node.y2, node.x2 + 1, node.y2, 1, node.cnt + 1);
                    }
                }
            }

            else {
                if(!outBound(node.x1, node.y1 - 1, node.x2, node.y2 - 1)) {
                    if(!visited(node.x1, node.y1, node.x1, node.y1 - 1, 0)) {
                        addQueue(node.x1, node.y1, node.x1, node.y1 - 1, 0, node.cnt + 1);
                    }

                    if(!visited(node.x2, node.y2, node.x2, node.y2 - 1, 0)) {
                        addQueue(node.x2, node.y2, node.x2, node.y2 - 1, 0, node.cnt + 1);
                    }
                }

                if(!outBound(node.x1, node.y1 + 1, node.x2, node.y2 + 1)) {
                    if(!visited(node.x1, node.y1, node.x1, node.y1 + 1, 0)) {
                        addQueue(node.x1, node.y1, node.x1, node.y1 + 1, 0, node.cnt + 1);
                    }

                    if(!visited(node.x2, node.y2, node.x2, node.y2 + 1, 0)) {
                        addQueue(node.x2, node.y2, node.x2, node.y2 + 1, 0, node.cnt + 1);
                    }
                }
            }
        }

        return -1;
    }

    private static boolean outBound(int x1, int y1, int x2, int y2) {
        if(x1 < 0 || y1 < 0 || x1 >= len || y1 >= len) {
            return true;
        }

        if(x2 < 0 || y2 < 0 || x2 >= len || y2 >= len) {
            return true;
        }

        if(board[x1][y1] == 1 || board[x2][y2] == 1) {
            return true;
        }

        return false;
    }

    private static boolean visited(int x1, int y1, int x2, int y2, int dir) {
        if(visit[x1][y1][dir] && visit[x2][y2][dir]) {
            return true;
        }

        return false;
    }

    private static void addQueue(int x1, int y1, int x2, int y2, int dir, int cnt) {
        visit[x1][y1][dir] = true;
        visit[x2][y2][dir] = true;
        queue.add(new Node(x1, y1, x2, y2, dir, cnt));
    }

    public int solution(int[][] board) {
        len = board.length;
        this.board = board;
        return bfs();
    }
}