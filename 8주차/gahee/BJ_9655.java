import java.util.*; 
import java.io.*; 

public class BJ_9655 { 


    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int n = Integer.parseInt(st.nextToken()); 
        int[] arr= new int[1001]; 
        arr[1]=1; 
        arr[2]=2; 
        arr[3]=3; 

        for (int i = 4; i <= n; i++) { 
            arr[i] = Math.min(arr[i-1],arr[i-3])+1; 
        } 

        if(arr[n]%2==0){ 
            System.out.println("CY"); 
        }else { 
            System.out.println("SK"); 
        } 
    } 

} 
