import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ip1 = sc.nextInt();

        int[] arr1 = new int[ip1];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        long[] dy = new long[101];

        dy[0] = 0;
        dy[1] = 1;
        dy[2] = 1;
        dy[3] = 1;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 4; j <= arr1[i]; j++) {
                dy[j] = dy[j - 2] + dy[j - 3];
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(dy[arr1[i]]);
        }
    }
}
