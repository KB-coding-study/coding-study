import java.util.*;
import java.io.*;

public class no1932 {

    static int N;
    static int[][] tree;
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        tree = new int[N][N];
        numArr = new int[N];
        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j <= i ; j++) {
                if (i==0){
                    tree[i][j] = Integer.parseInt(st.nextToken());
                }else {
                    if (j==0) {
                        tree[i][j] = tree[i-1][0] + Integer.parseInt(st.nextToken());
                    } else if (j==i) {
                        tree[i][j] = tree[i-1][j-1] + Integer.parseInt(st.nextToken());
                    } else {
                        if(tree[i-1][j-1]>=tree[i-1][j]) {
                            tree[i][j] = tree[i-1][j-1]+Integer.parseInt(st.nextToken());
                        } else {
                            tree[i][j] = tree[i-1][j] + Integer.parseInt(st.nextToken());
                        }
                    }
                }
            }
        }

        int MAX = 0;
        for (int i = 0 ; i < N ; i++) {
            if(tree[N-1][i]>MAX) {
                MAX = tree[N-1][i];
            }
        }
        System.out.println(MAX);
    }
}
