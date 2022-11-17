package study20221114;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b3190 {
	static class snake{
		int x, y;
		public snake(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;
	static int arr[][];
	static List<int[]> snake = new ArrayList<>();
	static HashMap<Integer, Character> l = new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a_x = Integer.parseInt(st.nextToken());
			int a_y = Integer.parseInt(st.nextToken());
			arr[a_x-1][a_y-1] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int c_x = Integer.parseInt(st.nextToken());
			char c_y = st.nextToken().charAt(0);
			l.put(c_x,c_y);
		}
		int time = 0;
		int cx = 0, cy = 0;
		int d = 0;
		snake.add(new int[] { 0, 0 });
		while(true) {
				// 1. 시간재기
				time++;

				// 2. 뱀 이동하기
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				// 3. 범위를 벗어나거나, 뱀 몸통 만날 때 종료
				if (isFinish(nx, ny))
					break;

				// 4. 사과가 있을 때 없을 때 처리
				if (arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					snake.add(new int[] { nx, ny });

				} else {
					snake.add(new int[] { nx, ny });
					snake.remove(0);
				}

				// 5. 방향을 바꿔주는 시간을 만날 때 방향 변경
				if (l.containsKey(time)) {
					if (l.get(time)=='D') {
						d += 1;
						if (d == 4)
							d = 0;
					} else {
						d -= 1;
						if (d == -1)
							d = 3;
					}
				}

				cx = nx;
				cy = ny;
			}
			System.out.println(time);
	}
	public static boolean isFinish(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
			return true;
		}

		for (int i = 0; i < snake.size(); i++) {
			int[] t = snake.get(i);
			if (nx == t[0] && ny == t[1])
				return true;
		}
		return false;
	}
}