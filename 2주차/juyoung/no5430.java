import java.util.*;
import java.io.*;

public class no5430 {

    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T; i++) {
            String functions = br.readLine();
            boolean reverse = false;
            boolean error = false;
            int n = Integer.parseInt(br.readLine());
            String[] strArr = br.readLine().replaceAll("\\[|\\]","").split(",");
            dq = new LinkedList<>();
            if (!Objects.equals(strArr[0], "")){
                for(int j = 0 ; j < strArr.length ; j++) {
                    dq.offerLast(Integer.parseInt(strArr[j]));
                }
            }
            for (int j = 0 ; j < functions.length() ; j++) {
                if (functions.charAt(j) == 'R') {
                    reverse = !reverse;
                } else {
                    if (!reverse) {
                        try {
                            dq.removeFirst();
                        } catch (Exception e) {
                            error = !error;
                            break;
                        }
                    } else {
                        try {
                            dq.removeLast();
                        } catch (Exception e) {
                            error = !error;
                            break;
                        }
                    }
                }
            }
            if(error) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int dqSize = dq.size();
            for (int j = 0 ; j < dqSize ; j++) {
                if(!reverse) {
                    sb.append(dq.pollFirst());
                } else {
                    sb.append(dq.pollLast());
                }
                if (j < dqSize-1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            String result = sb.toString();
            System.out.println(result);
        }
    }
}
