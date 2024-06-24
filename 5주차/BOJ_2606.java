package com.BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2606 {
    private static ArrayList<Integer>[] network;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numComputers = sc.nextInt();
        int numConnections = sc.nextInt();

        network = new ArrayList[numComputers + 1];
        visited = new boolean[numComputers + 1];

        for (int i = 1; i <= numComputers; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < numConnections; i++) {
            int computer1 = sc.nextInt();
            int computer2 = sc.nextInt();
            network[computer1].add(computer2);
            network[computer2].add(computer1);
        }


        int infectedCount = dfs(1) - 1;

        System.out.println(infectedCount);

        sc.close();
    }

    private static int dfs(int computer) {
        visited[computer] = true;
        int count = 1;

        for (int connectedComputer : network[computer]) {
            if (!visited[connectedComputer]) {
                count += dfs(connectedComputer);
            }
        }

        return count;
    }
}
