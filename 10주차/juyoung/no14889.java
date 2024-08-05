import java.io.*;
import java.util.*;

public class no14889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(combinations, new ArrayList<>(), N / 2, 0, N);

        int minDiff = Integer.MAX_VALUE;

        for (List<Integer> teamA : combinations) {
            List<Integer> teamB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!teamA.contains(i)) {
                    teamB.add(i);
                }
            }

            int scoreA = 0;
            int scoreB = 0;

            for (int i : teamA) {
                for (int j : teamA) {
                    scoreA += arr[i][j];
                }
            }

            for (int i : teamB) {
                for (int j : teamB) {
                    scoreB += arr[i][j];
                }
            }

            int diff = Math.abs(scoreA - scoreB);
            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }

    private static void generateCombinations(List<List<Integer>> combinations, List<Integer> current, int r, int start, int N) {
        if (current.size() == r) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < N; i++) {
            current.add(i);
            generateCombinations(combinations, current, r, i + 1, N);
            current.remove(current.size() - 1);
        }
    }
}
