import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//단지번호 붙이기
public class BJ_2667 {
	static class Apartment implements Comparable<Apartment>{
		int index;	//단지 번호
		int homeCnt;	//연결된 집 수
		
		public Apartment(int index, int homeCnt) {
			super();
			this.index = index;
			this.homeCnt = homeCnt;
		}
		@Override
		public int compareTo(Apartment o) {
			return this.homeCnt - o.homeCnt;
		}
	}
	
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	static List<Apartment> apartments;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		apartments = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				if(map[i][j]=='1')
					bfs(j, i);
			}
		}
		Collections.sort(apartments);
		
		int size = apartments.size();
		bw.write(size + "\n");
		for(int i=0; i<size; i++) {
			int value = apartments.get(i).homeCnt;
			bw.write(value + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visited[y][x] = true;
		
		int cnt=0;
		
		while(!q.isEmpty()) {
			for(int i=0,size=q.size(); i<size; i++) {
				Point now = q.poll();
				cnt++;
				
				for(int d=0; d<4; d++) {
					int nr = now.y + dr[d];
					int nc = now.x + dc[d];
					
					if(0<=nr && 0<=nc && nr<N && nc<N && map[nr][nc]=='1') {
						if(visited[nr][nc]) continue;
						visited[nr][nc] = true;
						q.add(new Point(nc, nr));
					}
				}
			}
		}//end of while
		int index = apartments.size();
		apartments.add(new Apartment(index, cnt));
	}
}
