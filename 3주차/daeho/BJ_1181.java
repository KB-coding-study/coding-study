import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        for(int i = 1; i < N; i++){
            int j = i;
            while(true){
                if(j == 0 ||arr[j - 1].length() <= arr[j].length()){
                    break;
                }
                else{
                    String s = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = s;
                    j--;
                }
            }
        }
        sb.append(arr[0]).append("\n");
        for(int i = 1; i < N; i++){
            if(!arr[i - 1].equals(arr[i]))
                sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
