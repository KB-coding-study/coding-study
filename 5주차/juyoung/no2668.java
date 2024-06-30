import java.util.*;
import java.io.*;
/***
 *  2. 방문 할 때마다 visited = true 으로 바꾸고 depth 증가.
 *  3. 방문 노드가 true면 방문 노드가 처음 노드인지 확인.
 *  4. answer에 추가.
 */
public class no2668 {

    static int N, answer=0, answerDFS;
    static int[] numArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N+1];

        for (int i = 1 ; i < N+1 ; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];

        for (int i = 1 ; i < N+1 ; i++) {
            if (!visited[i]) {
                dfs(i, i, 1);
                answer = answerDFS;
            }
        }
        System.out.println(answer);
        for (int i = 1 ; i < N+1 ; i++) {
            if (visited[i]) {
                System.out.println(i);
            }
        }
    }

    private static void dfs(int from, int idx, int depth) {
        answerDFS = answer;
        visited[idx] = true;
        int targetNode = numArr[idx];
        if (targetNode == from) {
            answerDFS += depth;
        }
        if (!visited[targetNode]) {
            dfs(from, targetNode, depth+1);
        }

        if (answer == answerDFS) {
            visited[idx] = false;
        }
    }
    // 1 2 3 4 5 6 7 8 9
    // 3 4 5 4 6 1 1 7 9
}
