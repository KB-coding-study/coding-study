package PSM_양과늑대;

import java.io.*;
import java.util.*;

public class Solution {

    int[] gInfo;
    int[][] gEdges;
    int maxSheepCnt = 0;

    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        boolean[] initVisited = new boolean[info.length];
        dfs(0, initVisited, 0, 0);

        return maxSheepCnt;
    }

    public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[idx] = true;
        if (gInfo[idx] == 0) {
            sheepCnt++;
            if (sheepCnt > maxSheepCnt) {
                maxSheepCnt = sheepCnt;
            }
        } else {
            wolfCnt++;
        }

        if (sheepCnt <= wolfCnt) {
            return;
        }

        for (int[] edge : gEdges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisited = new boolean[visited.length];
                for (int i = 0; i < visited.length; i++) {
                    nextVisited[i] = visited[i];
                }
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt);
            }
        }
    }
}

