import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class BJ1874{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        String[] strNumbers = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            number[i] = Integer.parseInt(strNumbers[i]);
            result[i] = -1;

            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if(number[i]>number[stack.peek()]) {
                while(!stack.isEmpty() && number[i] > number[stack.peek()]) {
                    int index = stack.pop();
                    result[index] = number[i];
                }
            }
            stack.push(i);
        }
        for(int i=0; i<n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
