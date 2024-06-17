import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        String [] inputs = new String[testcase];
        for (int i = 0; i <testcase; i++) {
            String s = br.readLine();
            inputs[i] = s;
        }


        Arrays.sort(inputs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                // 그 외의 경우
                else {
                    return o1.length() - o2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        sb.append(inputs[0]).append('\n');

        for (int i = 1; i < testcase; i++) {
            // 중복되지 않는 단어만 출력
            if (!inputs[i].equals(inputs[i - 1])) {
                sb.append(inputs[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}




