import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        int arr[]=new int[n*2];
        int prev=0;
        int last=n-1;

        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }

        while(n>1){
            prev++; // 먼 처음 위치 카드 다음 카드 지목
            arr[last+1]=arr[prev]; // 마지막 위치에 저장
            last++;
            prev++;
            n--;
        }
        System.out.println(arr[prev]);
    }
}
