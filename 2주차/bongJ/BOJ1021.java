package bongJ;

import java.io.*;
import java.util.*;

public class BOJ1021 {

    static LinkedList<Integer> queue = new LinkedList<>(); //입력받은 모든 수 저장(큐/덱)

    static int[] getArr; //뽑고자 하는 숫자들을 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기 N
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려눈 수의 개수 M

        //큐에 1부터 N까지 담아둔다.(초기 값)
        for(int i = 1; i <= N; i++){
            queue.offer(i); //offer() : ()괄호 안에 있는 값을 큐에 저장하는 함수
        }

        st = new StringTokenizer(br.readLine());

        getArr = new int[M]; //배열 선언(초기화)

        //뽑고자 하는 숫자들을 배열에 저장
        for(int i = 0; i < M; i++){
            getArr[i] =  Integer.parseInt(st.nextToken());
        }

        br.close();

        System.out.println(solution(M));
    }


    //솔루션(최소 비용을 구하는 메소드) - 파라미터 : 뽑으려는 숫자의 개수
    static int solution(int M){
        int cost = 0; //비용(최소)
        //찾으려는 숫자의 개수만큼 반복하고 찾았을 때 증가한 cost만큼 누적더하기 하면 됨
        for(int i = 0; i < M; i++){
            //찾으려는 숫자의 인덱스 값을 넣어 줌
            // 인덱스 값을 기준으로 잡은 이유 : 숫자들이 이동하면서 크기로 비교하기엔 무리가 있음
            int targetIndex = queue.indexOf(getArr[i]);
            int middleIndex; //중간 인덱스 값

            //큐의 사이즈(저장된 숫자가 짝수 개이면)
            if(queue.size() % 2 == 0){
                //인덱스는 0부터 시작하기 때문에 -1을 해줌
                middleIndex = queue.size() / 2 - 1;
            }else{ //홀수 개이면
                //홀수 개일 경우는 차피 한쪽이 1개 더 많으니 -1 해주지X
                middleIndex = queue.size() / 2 ;
            }

            //중간 지점이거나 중간 지점보다 앞에 있을 경우(2번 : 앞에서 뒤로)
            if(targetIndex <= middleIndex){
                for(int j = 0; j < targetIndex; j++){
                    //찾으려는 숫자의 인덱스보다 앞에 있는 원소들을 모두 뒤로 보낸다.
                    int tmp = queue.pollFirst();
                    queue.offerLast(tmp);
                    //2번 연산이므로 cost증가
                    cost++;
                }
            }
            else{ //중간 지점보다 뒤에 있을 경우 (3번 : 뒤에서 앞으로)
                for(int j = 0; j < queue.size() - targetIndex; j++){
                    // 찾으려는 숫자의 인덱스보다 뒤에 있는 요소들을 모두 앞으로 보낸다.
                    int tmp = queue.pollLast();
                    queue.offerFirst(tmp);
                    //3번 연산이므로 cost 증가
                    cost++;
                }
            }
            // 최종적으로 모든 수행(앞의 로직)이 끝나면 가장 앞에 뽑으려는 숫자가 있는 것이므로
            // 1번 연산 : 그냥 뽑으면 된다.
            queue.pollFirst();
        }

        return cost;
    }

}
