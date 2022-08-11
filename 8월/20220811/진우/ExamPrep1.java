import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 1227. [S/W 문제해결 기본] 7일차 - 미로2
public class ExamPrep1 {
	static int ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	
	// 일단 방문 가능 여부만 물어보니까 dfs로 처리가능. 
	static void dfs(int x, int y) {
		map[x][y] = 1; // (참고-1)
		
		// 각 위치에서 4방을 탐색할 수 있다. 그리고 각 방향에 dfs를 하고 돌아오면 이어서 다음 방향의 탐색을 시작한다.
		// 고로 현재 위치 도착하자마자 바로 방문처리해도 좋다.  (참고-1)
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			// 범위를 넘어서거나, 벽이거나/이미방문했거나(1로 방문체크) 이면 건너뛰기 
			if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
			if(map[nx][ny] == 1) continue;
			
			if(map[nx][ny] == 3) {
				ans = 1;
				return;
			}
			//map[nx][ny] = 1; (참고-1)
			dfs(nx, ny);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			sc.nextInt();
			
			map = new int[100][100];
			int sx=0, sy=0;
			
			ans = 0;
			
			for(int i=0; i<100; i++) {
				String str = sc.next();
				for(int j=0; j<100; j++) {
					map[i][j] = str.charAt(j) - '0'; // -'0'을 안하면 '1'의 정수값인 49가 들어간다.
					if(map[i][j] == 2) {
						sx = i;
						sy = j;
					}
				}
			}
			
			dfs(sx, sy);
			System.out.println("#"+t+" "+ans);
		}
	}

}
