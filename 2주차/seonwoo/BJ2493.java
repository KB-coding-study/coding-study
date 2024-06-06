import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(s.isEmpty()) {
                sb.append(0+" ");
            }
            else{
                while(true) {
                    int[] value = s.peek();
                    int idx = value[0];
                    int h = value[1];
                    if(h > num) {
                        sb.append(idx+" ");
                        break;
                    }else {
                        s.pop();
                    }

                    if(s.isEmpty()) {
                        sb.append(0+" ");
                        break;
                    }
                }
            }
            s.push(new int[] {i+1, num});
        }
        System.out.println(sb.toString());
    }
}
