import java.io.*;
import java.util.*;

public class BJ_14891{
    static boolean[][] gear = new boolean[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i=0;i<4;i++){
            String state = br.readLine();
            setGear(i, state);
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            startGear(n, direction);
        }
        int answer = gearCheck();
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
    static int gearCheck(){
        int answer = 0;
        for(int i=0;i<4;i++){
            if(gear[i][0])
                answer += Math.pow(2, i);
        }
        return answer;
    }
    static void startGear(int index, int direction){
        boolean magnet = gear[index][2];
        int nDirection = direction;
        for(int i=index+1;i<4;i++){
            if(gear[i][6] != magnet){
                magnet = gear[i][2];
                nDirection *= -1;
                rotate(i, nDirection);
            }else
                break;
        }
        magnet = gear[index][6];
        nDirection = direction;
        for(int i=index-1;i>=0;i--){
            if(gear[i][2] != magnet){
                magnet = gear[i][6];
                nDirection *= -1;
                rotate(i, nDirection);
            }else
                break;
        }
        rotate(index, direction);
    }
    //톱니바퀴 회전 진행하는 함수
    static void rotate(int index, int rotate){
        boolean temp;
        if(rotate == 1){
            temp = gear[index][7];
            for(int i=7;i>0;i--)
                gear[index][i] = gear[index][i-1];
            gear[index][0] = temp;
        }else{
            temp = gear[index][0];
            for(int i=0;i<7;i++)
                gear[index][i] = gear[index][i+1];
            gear[index][7] = temp;
        }
    }
    static void setGear(int index, String state){
        for(int i=0;i<8;i++){
            if(state.charAt(i) == '1')
                gear[index][i] = true;
            else
                gear[index][i] = false;
        }
    }
}
