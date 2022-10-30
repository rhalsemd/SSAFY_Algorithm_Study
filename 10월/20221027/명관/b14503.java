package study20221027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14503 {
	static int N, M, cnt=0;
	static int mat[][], visited[][];
	static int[] dx= {-1, 0, 1, 0};
	static int[] dy= {0, 1, 0, -1};
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		int d= Integer.parseInt(st.nextToken()); // 0북, 1동, 2남, 3서
		
		mat= new int[N][M];
		visited= new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		cnt++;
		dfs(r, c, d);
		
		System.out.println(cnt);
    }
	public static void dfs(int x, int y, int dir) {
		int nx, ny, cant=0;
		visited[x][y]=1;
		for(int i=0; i<4; i++) {
			dir= dir-1<0 ? 3:dir-1;
			nx= x+dx[dir];
			ny= y+dy[dir];
			if(nx<0||nx>=N||ny<0||ny>=M) {
			}else if(mat[nx][ny]==0&&visited[nx][ny]==0) {
				dfs(nx, ny, dir);
				cnt++;
				break;
			}
			cant++;
		}
		x= x-dx[dir];
		y= y-dy[dir];
		if(x<0||x>=N||y<0||y>=M) {
			return;
		}else if(cant==4&&mat[x][y]==0) {
			dfs(x, y, dir);
		}
	}
}	