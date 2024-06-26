package BJ1874;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();	// 출력값
		
		int n = in.nextInt();
		int temp= 0; // 스택 삽입 시 기준 값
		
		while(n>0) {
			int num = in.nextInt();
			
			if(num>temp) {
				for(int i = temp + 1; i <= num; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				temp = num; 
			}
			
			else if(stack.peek() != num) {
				System.out.println("NO");
				return; // 함수 종료 
			}
			stack.pop();
			sb.append("-\n");
			n--; // 횟수 차감
		}
		System.out.println(sb);
	}
}