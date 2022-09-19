import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//안전 영역
public class BJ_2468 {
	static int N, resHigh, safetyPointCnt;
	static int maxHigh = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(maxHigh < value) maxHigh = value;
			}
		}
		
		for(int i=0; i<=maxHigh; i++) {
			int cnt = 0;
			visited = new boolean[N][N];
			
			for(int row=0; row<N; row++) {
				for(int col = 0; col<N; col++) {
					if(visited[row][col]) continue;
					if(map[row][col] <= i) {
						visited[row][col] = true;		//안전지대가 될 수 없으니 체크
						continue;
					};
					bfs(i, row, col);
					cnt++;
				}
			}
			if(cnt > safetyPointCnt) {		//안전지대가 더 많은
				safetyPointCnt = cnt;
				resHigh = i;
			}
		}
		
		bw.write(safetyPointCnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
	static void bfs(int high, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(c, r));
		visited[r][c] = true;

		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int d=0; d<4; d++) {
				int nr = now.y + dr[d];
				int nc = now.x + dc[d];
				
				if(0<=nr && nr<N && 0<=nc && nc<N && map[nr][nc]>high && !visited[nr][nc]) {
					q.add(new Point(nc, nr));
					visited[nr][nc] = true;
				}
			}
		}
		
	}
}
