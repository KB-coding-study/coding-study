import java.util.*;
import java.io.*;

public class Main{

	static int dy[]= {-1,0,1,0};
	static int dx[]= {0,-1,0,1};
	static char dice[]=new char[6];
	static StringBuilder sb=new StringBuilder();
	static char map[][];
	static int y,x;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		Arrays.fill(dice,'0');
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
	
		map=new char[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=st.nextToken().charAt(0);
			}
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int num=Integer.parseInt(st.nextToken());
			rollDice(num);
		}
		
		System.out.println(sb);
		
		
	}
	public static void rollDice(int num) {
		
		int prevY=y;
		int prevX=x;
		
		switch(num) {
		case 1: x++; break;
		case 2: x--; break; 
		case 3: y--; break;
		case 4: y++; break;
		}
		
		
		//범위 넘어가면 명령 무시
		if(y<0||x<0||y>=map.length||x>=map[0].length) {
			y=prevY;
			x=prevX;
			return;
		}
			
	
	
		char copyDice[]=dice.clone();
		
	
			
		switch(num) {
		case 1: 
			dice[1]= copyDice[4]; dice[3]= copyDice[5];
			dice[4]= copyDice[3]; dice[5]= copyDice[1];
			break;
		case 2:
			dice[1]= copyDice[5]; dice[3]= copyDice[4];
			dice[4]= copyDice[1]; dice[5]= copyDice[3];
			break;
		case 3:
			dice[0]= copyDice[1];	dice[1]= copyDice[2];
			dice[2]= copyDice[3];	dice[3]= copyDice[0];
			break;
		case 4:
			dice[0]= copyDice[3];	dice[1]= copyDice[0];
			dice[2]= copyDice[1];	dice[3]= copyDice[2];
			break;
		}
		if(map[y][x]=='0')
			map[y][x]=dice[3];
		else {
			dice[3]=map[y][x];
			map[y][x]='0';
		}
		
	
		sb.append(dice[1]).append('\n');
		
		
		
	}
	
}