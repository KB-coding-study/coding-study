package com.tp;

import java.util.Scanner;

public class BOJ_2003 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int st = 0;
        int ed = 0;
        sc.nextLine();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            arr[i] = x;
        }


        int answer = 0;
        while(st <= ed && ed < N){
            int sum = 0;
            for(int i = st; i<=ed; i++){
                sum += arr[i];
            }

            if(sum == M){
                answer++;

            }else if(sum > M){
                if(st == ed){
                    ed++;
                }else{
                    st++;
                }

                continue;
            }

            ed++;


        }

        System.out.println(answer);



    }
}
