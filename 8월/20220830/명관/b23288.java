package baekjoon_20220830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b23288 {
	static int N, M, K, d, x, y, B, C;
	static int[][] map, dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } } // 동남서북
			, dice = { { 0, 2, 0, 0 }, { 4, 1, 3, 6 }, { 0, 5, 0, 0 }, { 0, 6, 0, 0 } }; //주사위 초기 세팅
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d = 0;
		x = 0;
		y = 0;

		int answer = 0;
		for (int tc = 1; tc <= K; tc++) {
			//이동 방향으로 한칸 굴러간다.
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			//이동 방향에 칸이 없다면, 이동 방향을 반대로 설정.
			if (!isInside(nx, ny)) {
				d = (d + 2) % 4; // 반대방향
				nx = x + dir[d][0];
				ny = y + dir[d][1];
			}
			// 동
			if (d == 0) {
				int value = dice[1][3];
				for (int j = 3; j >= 1; j--) {
					dice[1][j] = dice[1][j - 1];
				}
				dice[1][0] = value;
				dice[3][1] = dice[1][3];
			}
			// 남
			else if (d == 1) {
				int value = dice[3][1];
				for (int i = 3; i >= 1; i--) {
					dice[i][1] = dice[i - 1][1];
				}
				dice[0][1] = value;
				dice[1][3] = dice[3][1];
			}
			// 서
			else if (d == 2) {
				int value = dice[1][0];
				for (int j = 0; j <= 2; j++) {
					dice[1][j] = dice[1][j + 1];
				}
				dice[1][3] = value;
				dice[3][1] = dice[1][3];
			}
			// 북
			else if (d == 3) {
				int value = dice[0][1];
				for (int i = 0; i <= 2; i++) {
					dice[i][1] = dice[i + 1][1];
				}
				dice[3][1] = value;
				dice[1][3] = dice[3][1];
			}

			//주사위가 도착한 칸(x, y)에 대한 점수를 획득한다.
			visited = new boolean[N][M];
			C = 1;
			B = map[nx][ny];
			dfs(nx, ny, B);
			answer += (B * C);

			//주사위 아랫면에 있는 정수와 칸(x, y) 에 있는 정수 B를 비교해서 이동방향 결정
			int A = dice[1][3];

			if (A > B) {
				d = (d + 1) % 4;
			} else if (A < B) {
				d = (d + 3) % 4;
			}

			x = nx;
			y = ny;
		}
		System.out.println(answer);
	}

	public static void dfs(int x, int y, int v) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (isInside(nx, ny) && !visited[nx][ny] && v == map[nx][ny]) {
				C++;
				dfs(nx, ny, v);
			}
		}
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
