import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] t = new int[n];
        for(int i = 0; i < n; i++)
            t[i] = (Integer.parseInt(st.nextToken()));

        int time = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        // queue의 값을 0으로 다 초기화
        for(int i = 0; i < w; i++)
            q.add(0);

        for(int i = 0; i < t.length; i++) {
            sum -= q.poll();
            if (sum + t[i] > l) {
                q.add(0);
                i--;
            }else { //더 들어갈 수 있는 경우
                q.add(t[i]);
                sum += t[i];
            }
            time++;
        }

        System.out.println(time + w);
    }
}