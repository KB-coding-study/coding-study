import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T;  i++){
            String fun = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String[] arr = a.substring(1, a.length() - 1).split(",");
            Deque<String> deque = new LinkedList<>();

            for(int j = 0; j < n; j++){
                deque.add(arr[j]);
            }
            int count = 0;
            Boolean empty = false;
            for(int j = 0 ; j < fun.length(); j++){
                if(fun.charAt(j) == 'R') {
                    count++;
                }
                else if(deque.isEmpty()){
                    empty = true;
                    break;
                }
                else if (count % 2 != 0){
                    deque.pollLast();
                }
                else{
                    deque.pollFirst();
                }
            }
            if(deque.isEmpty() && empty) {
                sb.append("error").append("\n");
            }
            else if(deque.isEmpty()){
                sb.append("[]\n");
            }
            else if(count % 2 == 0){
                sb.append("[");
                int k = deque.size();
                for(int j = 0; j < k - 1; j++){
                    sb.append(deque.pollFirst()).append(",");
                }
                sb.append(deque.pollFirst()).append("]").append("\n");
            }
            else {
                sb.append("[");
                int k = deque.size();
                for(int j = 0; j < k - 1; j++){
                    sb.append(deque.pollLast()).append(",");
                }
                sb.append(deque.pollLast()).append("]").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}