mport java.util.*;
import java.io.*;

public class BJ_14499{

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
		int N=Integer.parseInt(st.nextToken(