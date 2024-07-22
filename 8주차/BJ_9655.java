import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if(N % 4 == 1 || N % 4 == 3){
            sb.append("SK");
        }
        else
            sb.append("CY");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}