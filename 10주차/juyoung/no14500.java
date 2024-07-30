import java.util.*;
import java.io.*;



public class no14500 {
		 
	 	static int R,C;
	 	static int map[][] =new int[501][501];
	 	static boolean visit[][] = new boolean[501][501];
	 	static int sum=0, max=Integer.MIN_VALUE;
	 	static int dx[] = {0,-1,1,0};
	 	static int dy[] = {-1,0,0,1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<R; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				dfs(i,j,0,0);
				 
				other(i,j);
			}
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
	  
	}

	private static void other(int x, int y) {
		// TODO Auto-generated method stub
				int[] dxdy = {-1,-1,-1,-1};
				
				int n =0;
				int min =Integer.MAX_VALUE;
				int s =0;
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C) {
						n++;
						continue;
					}
					dxdy[i] = map[nx][ny];
					min = min>dxdy[i] ? dxdy[i] : min;
					s += dxdy[i];
				}
				
				int ans =0;
				if(n>=2)return;
				else if(n==1)ans = s+map[x][y];
				else if(n==0)ans = s+map[x][y]-min;
				max = max <ans ? ans : max;
	}

	private static void dfs(int x, int y, int depth, int sum) {
		// TODO Auto-generated method stub
		if(depth ==3) {
			sum += map[x][y];
			max = max < sum ? sum : max;
			return;
		}
		visit[x][y]=true;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || ny <0 || nx>=R || ny>=C)continue;
			if(visit[nx][ny])continue;
			
			dfs(nx,ny,depth+1, sum+map[x][y]);
		}
		visit[x][y]=false;
	}

	
 
}
