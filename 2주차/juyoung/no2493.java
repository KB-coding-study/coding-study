import java.io.*;
import java.util.*;

public class no2493 {

    static Stack<Integer> heights, indices;
    static int[] receiveList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        receiveList = new int[N];
        heights = new Stack<Integer>();
        indices = new Stack<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int inputHeight = Integer.parseInt(st.nextToken());

            while (!heights.isEmpty() && heights.peek() < inputHeight) {
                heights.pop();
                indices.pop();
            }

            if (heights.isEmpty()) {
                receiveList[i] = 0;
            } else {
                receiveList[i] = indices.peek() + 1; // 1-based index
            }

            heights.push(inputHeight);
            indices.push(i);
        }

        System.out.print(receiveList[0]);
        for (int i = 1; i < N; i++) {
            System.out.print(" " + receiveList[i]);
        }
    }
}