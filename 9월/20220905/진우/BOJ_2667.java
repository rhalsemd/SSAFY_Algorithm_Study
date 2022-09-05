package study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ2667 {
	static int N;
	static int[][] arr;
	static int[][] visited;
	
	static ArrayList<Integer> list = new ArrayList<>();
	// 상하좌우 
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			String temp = sc.next();
			for(int j=0; j<N; j++) {
				arr[i][j] = temp.charAt(j) -'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1) {
					if(visited[i][j] == 0)
						list.add(dfs(i, j, 0));
				}
			}
		}
		
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
		
		System.out.println(list.size());
		for(int l : list) {
			System.out.println(l);
		}
	}
	
	private static int dfs(int x, int y, int cnt) {
		visited[x][y] = 1;
		cnt++; // 1, 2, 3, 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx >= N | ny<0 || ny >= N) continue;
			if(visited[nx][ny] == 1) continue;
			if(arr[nx][ny] == 0) continue;
			
			cnt = dfs(nx, ny, cnt);  // 1, 2, 3, 4, 5, 6, 7 
		}
		
		return cnt;
	}
}
