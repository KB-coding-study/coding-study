package bongj;

import java.util.Scanner;

public class BOJ1699 {

    public static void main(String[] args) {
        BOJ1699 practice = new BOJ1699();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int n=0;
        int best=999;
        while((n+1)*(n+1)<=input)
            n++;


        while(n>0) {
            int rst = practice.getMinSquareSum(input, 0, n);
            if(rst < best)
                best = rst;
            n--;
        }
        System.out.println(best);
    }


    private int getMinSquareSum(int input, int cnt, int n) {
        int k=0;
        while(input>=(k+1)*(k+1) && n>=k)
            k++;
        if(input==0)
            return cnt;
        else {
            if(input-k*k>=0)
                return getMinSquareSum(input-k*k, cnt+1, n);
            else
                return 1000;
        }
    }
}