    import java.io.*;
    import java.util.*;

    public class Main {
        static int N, M, virusNum, emptyNum, answer;
        static boolean[][] visited;
        static int[][] map, virus;
        static List<int[]> list;
        static int[] dx = {0, 0, -1, 1};
        static int[] dy = {1, -1, 0, 0};


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            virus = new int[10][2];
            answer = N * N;
            virusNum = 0;
            emptyNum = 0;
            list = new ArrayList<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 2){
                        virus[virusNum][0] = i;
                        virus[virusNum][1] = j;
                        virusNum++;
                    }
                    else if (map[i][j] == 0){
                        emptyNum++;
                    }

                }
            }

            int arr[] = new int[virusNum];
            for(int i = 0; i < virusNum; i++){
                arr[i] = i;
            }


            combination(arr, new int[M], 0, new boolean[virusNum], 0);
            for(int[] virus : list){
                BFS(virus);
            }

            if(answer == N * N){
                bw.write("-1");
            }
            else
                bw.write(String.valueOf(answer));
            bw.flush();
            bw.close();


        }

        static void combination(int[] arr, int[] out, int start, boolean[] visitedCom, int depth){
            if(depth == M){
                list.add(out.clone());
                return;
            }
            for(int i = start; i < arr.length; i++){
                if(!visitedCom[i]){
                    visitedCom[i] = true;
                    out[depth] = arr[i];
                    combination(arr, out, i + 1, visitedCom, depth + 1);
                    visitedCom[i] = false;
                }
            }
        }

        static void BFS(int[] arr){
            Queue<Node> queue = new LinkedList<>();
            int count = 0;
            int infected = 0;
            visited = new boolean[N][N];
            for (int vi : arr){
                queue.add(new Node(virus[vi][0], virus[vi][1]));
                visited[virus[vi][0]][virus[vi][1]] = true;
            }

            if(emptyNum == 0){
                answer = 0; // 빈 칸이 없는 경우에는 모두 퍼져 나간 상태이므로 0으로 초기화
                return;
            }

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i < size; i++){
                    Node current = queue.poll();
                    for(int j = 0; j < 4; j++){
                        int nx = current.x + dx[j];
                        int ny = current.y + dy[j];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 1)
                            continue;
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        if(map[nx][ny] == 0)
                            infected++;
                    }
                }
                count++;
                if(infected == emptyNum){
                    answer = Math.min(answer, count);
                    return;
                }
            }
        }

        static class Node{
            int x, y;
            public Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }