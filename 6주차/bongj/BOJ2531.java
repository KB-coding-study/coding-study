package bongj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            Set<Integer> set = new HashSet<>();
            set.add(C);
            for(int j=0; j<K; j++)
            {
                int index = i+j;
                if(i+j >= N)
                {
                    index = i+j-N;
                }
                set.add(arr[index]);
            }
            result = Math.max(result,set.size());
        }
        System.out.println(result);
    }
    }
}
