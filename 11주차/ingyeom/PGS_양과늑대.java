import java.util.*;

class Solution {
    static List<Integer> parent;
    static boolean []check;
    static List<List<Integer>> graph;
    static int len;
    static int sheep, wolf, answer;

    public void dfs(int node, List<Integer> parent, int[] info) {
        List<Integer> tmp = new ArrayList<>(parent);
        for (int i = 0; i < parent.size(); i++) {
            int pick = parent.get(i);
            if (!check[pick] && sheep > wolf + info[pick]) {
                if (info[pick] == 0)
                    sheep++;
                else
                    wolf++;

                for (int k = 0; k < graph.get(pick).size(); k++)
                    tmp.add(graph.get(pick).get(k));

                check[pick] = true;
                answer = Math.max(sheep, answer);
                dfs(pick, tmp, info);
                tmp = new ArrayList<>(parent);
                check[pick] = false;

                if (info[pick] == 0)
                    sheep--;
                else
                    wolf--;
            }
        }
    }

    public int solution(int[] info, int[][] edges) {
        answer = 1;
        len=info.length;
        graph =new ArrayList<>();

        for(int i=0; i<len; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<len-1; i++)
            graph.get(edges[i][0]).add(edges[i][1]);

        check=new boolean[len];
        parent= new ArrayList<>();
        for(int i=0; i<graph.get(0).size(); i++)
            parent.add(graph.get(0).get(i));

        sheep=1;
        wolf=0;
        check[0]=true;
        dfs(0, parent, info);

        return answer;
    }
}