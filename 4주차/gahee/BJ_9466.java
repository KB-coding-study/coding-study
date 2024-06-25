import java.io.*;
import java.util.*;

public class BJ_9466 {

    static boolean[] visitied ;
    static int[] numbers ;
    static boolean[] finish;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int a=0; a<t; a++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            numbers = new int[n+1];
            finish = new boolean[n+1];

            String[] strings = br.readLine().split(" ");
            for(int i=0; i<strings.length; i++) {
                numbers[i+1] = Integer.parseInt(strings[i]);
            }
            count = 0;
            visitied = new boolean[n+1];
            for(int i=1; i<=n; i++) {
                dfs(i);
            }
            sb.append(n-count).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int i) {
        if(visitied[i]) return; // 이미 방문한 노드는 스킵
        visitied[i] = true; // 현재 노드를 방문 처리
        int next = numbers[i]; // 다음에 방문할 노드
        if(!visitied[next]) dfs(next); // 다음 노드를 방문하지 않았다면 재귀적으로 탐색 계속
        else {
            if(finish[next]==false) { // 다음 노드가 이미 방문되었으나 탐색이 완료되지 않은 경우, 즉 사이클이 발견된 경우
                count++; // 현재 노드를 사이클에 포함된 노드로 카운트
                for(int temp = next; temp != i; temp = numbers[temp]) {
                    count++; // 사이클을 이루는 나머지 노드들 카운트
                }
            }
        }
        finish[i] = true; // 현재 노드의 탐색을 완료
    }
}
