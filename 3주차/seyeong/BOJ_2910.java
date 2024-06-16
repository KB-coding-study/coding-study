package com.ohgiraffers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = sc.nextInt();
        }


        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        HashMap<Integer, Integer> firstAppearance = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = sequence[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (!firstAppearance.containsKey(num)) {
                firstAppearance.put(num, i);
            }
        }


        Integer[] sortedSequence = new Integer[N];
        for (int i = 0; i < N; i++) {
            sortedSequence[i] = sequence[i];
        }

        Arrays.sort(sortedSequence, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int freq1 = frequencyMap.get(o1);
                int freq2 = frequencyMap.get(o2);
                if (freq1 != freq2) {
                    return freq2 - freq1;
                } else {
                    return firstAppearance.get(o1) - firstAppearance.get(o2);
                }
            }
        });


        for (int num : sortedSequence) {
            System.out.print(num + " ");
        }


    }
}
