import java.io.*;
import java.util.*;

public class no14888 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 리스트 생성
        List<Character> symbols = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < arr2[i]; j++) {
                if (i == 0) {
                    symbols.add('+');
                } else if (i == 1) {
                    symbols.add('-');
                } else if (i == 2) {
                    symbols.add('*');
                } else if (i == 3) {
                    symbols.add('/');
                }
            }
        }

        // 연산자 순열 생성
        List<List<Character>> listSymbol = permutations(symbols);

        int INF = (int) 1e9;
        int Min = INF;
        int Max = -INF;

        // 최대값, 최소값 계산
        for (List<Character> symbolList : listSymbol) {
            int s = arr[0];
            for (int j = 1; j < arr.length; j++) {
                char symbol = symbolList.get(j - 1);
                if (symbol == '+') {
                    s += arr[j];
                } else if (symbol == '-') {
                    s -= arr[j];
                } else if (symbol == '*') {
                    s *= arr[j];
                } else if (symbol == '/') {
                    s /= arr[j];
                }
            }
            Max = Math.max(Max, s);
            Min = Math.min(Min, s);
        }

        // 결과 출력
        System.out.println(Max);
        System.out.println(Min);
    }

    public static List<List<Character>> permutations(List<Character> symbols) {
        List<List<Character>> result = new ArrayList<>();
        permuteHelper(symbols, 0, result);
        return result;
    }

    private static void permuteHelper(List<Character> symbols, int index, List<List<Character>> result) {
        if (index == symbols.size() - 1) {
            result.add(new ArrayList<>(symbols));
            return;
        }

        for (int i = index; i < symbols.size(); i++) {
            Collections.swap(symbols, index, i);
            permuteHelper(symbols, index + 1, result);
            Collections.swap(symbols, index, i);
        }
    }
}