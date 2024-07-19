package bongj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10942{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][n+1];
        int input[] = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=1;j<=n;j++){
            int temp = Integer.parseInt(st.nextToken());
            input[j]=temp;
            for(int i=1;i<=j;i++){
                if(i==j)arr[i][j]=1;
                else if(j-i==1) arr[i][j] = (input[j]==input[i])?1 : 0;
                else {
                    arr[i][j] = (input[j]==input[i] && arr[i+1][j-1]==1)?1 : 0;
                }
            }
        }

        int TC = Integer.parseInt(br.readLine());
        while(TC --> 0 ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(arr[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}
