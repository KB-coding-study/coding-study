import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i] = Integer.parseInt(st.nextToken());  // 이런 방식 가능

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(IntStream.of(dp).max().getAsInt()));
//        bw.write(Integer.toString(IntStream.of(dp).max().getAsInt()));
        /*
        - String.valueOf()와 Integer.toString()의 차이
        - 출처 : https://olrlobt.tistory.com/61

        1. 파라미터가 int일 때 = 다른 점이 없음!
        String.valueOf()가 내부에서 Integer.toString()를 호출하기에 호출스택이 1 더 쌓이지만,
        JVM에서의 메서드 최적화 프로세스인 인라이닝을 통해, 결과적으로는 아주 같은 결과를 제공한다고 한다.

        2. 파라미터가 Integer일 때 = NPE발생!!!
        Integer의 값이 null이 아니라면 상관없지만,
        null인 경우에는 Integer.toString()은 NPE를 발생시킨다.

        결론 : '정수 -> 문자열' 변환은 String.valueOf()를 사용하자
         */
        bw.close();
    }
}