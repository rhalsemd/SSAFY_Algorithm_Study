import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj로봇청소기 {
	static int N,M, sx, sy, curDir;
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int cnt;
	static Queue<int[]> q;
	
	static int[][] dirMap= {
			{0,1,2,3},
			{1,2,3,0},
			{2,3,0,1},
			{3,0,1,2}			
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		curDir = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		cnt = 0;
		q = new LinkedList<>();
		q.add(new int[] {sx, sy});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {	
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(cnt);
	}

	private static void bfs() {
		while(true) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			arr[x][y] = 2;
			cnt++;
			
			int rotate = 0;
			int nx,ny;
			
			while(true) {
				if(rotate == 4) {
					nx = x+dx[dirMap[curDir][2]];
					ny = y+dy[dirMap[curDir][2]];
					
					if(arr[nx][ny] != 1) {
						//q.add(new int[] {nx, ny});
						x = nx; 
						y = ny;
						rotate = 0;
					}
					else if(arr[nx][ny] == 1) return;
				}
				
				int left = dirMap[curDir][3];
				 nx = x+dx[left];
				 ny = y+dy[left];
				
				if(arr[nx][ny] == 0) {
					curDir = left;
					x = nx;
					y = ny;
					q.add(new int[]{nx, ny});
					break;
				}
				else {
					curDir = left;
					rotate++;
				}
				
				//print(x,y);
			}
		}
	}

	private static void print(int x, int y) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i==x && j==y) {
					System.out.print("*"+" ");
				}
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	
	}

}
