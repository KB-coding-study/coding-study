import java.util.Scanner;

public class no2606 {

    static int[][] arr;
    static boolean[] visited;
    private int solution(int N){

        visited[N]=true;

        for ( int i = 1 ; i < arr.length ; i++ ) {
            if( arr[N][i] == 1 && !visited[i] ) {
                solution(i);
            }
        }


        return 0;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N+1][N+1];
        for ( int i = 0 ; i < M ; i++ ) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N+1];
        T.solution(1);

        int answer = 0;
        for ( int i = 1 ; i < N + 1 ; i++ ) {
            if ( visited[i] ) answer++;
        }
        System.out.print(answer-1);
    }
}
