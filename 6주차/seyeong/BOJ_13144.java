package com.tp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BOJ_13144 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> hs = new HashSet<>();
        int st = 0;
        int ed = 0;
        long answer = 0;

        while(ed < N && st <=ed){
            for(int i = st; i<=ed; i++){
                if(!hs.contains(arr[i])){
                    hs.add(arr[i]);
                    ed++;
                    if(ed >=N){
                        break;
                    }

                }else{
                    answer += hs.size();
                    st++;
                    ed = st;
                    hs.clear();
                }
            }
        }


        if(!hs.isEmpty()){
            for(int i = 1; i<=hs.size(); i++){
                answer += i;
            }
        }

        System.out.println(answer);

    }
}
