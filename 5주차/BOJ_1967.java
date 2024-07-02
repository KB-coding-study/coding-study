package com.DFS;

import java.util.*;

public class BOJ_1967 {

    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farthestNode = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int weight = sc.nextInt();
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }


        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node neighbor : tree[node]) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, distance + neighbor.weight);
            }
        }
    }
}
