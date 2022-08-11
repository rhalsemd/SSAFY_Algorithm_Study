import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//미로2
public class D4_1227 {
	static int startR, startC;
	static int[][] map;
	static int[][] tmpMap;
	static int start = 2;
	static int goal = 3;
	static int result;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = 10;

		for (int t = 1; t <= tc; t++) {
			br.readLine();

			map = new int[100][100];
			tmpMap = new int[100][100];
			result = 0;

			for (int i = 0; i < 100; i++) { // 맵 입력
				char[] mapInput = br.readLine().toCharArray();
				
				for (int j = 0; j < 100; j++) {
					int m = mapInput[j] - '0';
					if (m == start) {
						startR = i;
						startC = j;
					}
					map[i][j] = m;
					tmpMap[i][j] = m;
				}
			}
			runMaze(startR, startC);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(result).append("\n");
			bw.write(sb.toString());
		} // end of testCase for
		
		bw.flush();
		bw.close();
	}

	private static void runMaze(int r, int c) {
		if(result == 1) return;
		
		for (int i = 0; i < 4; i++) { // 사방 탐색
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < 100 && nc < 100) { // 범위 밖
				if (tmpMap[nr][nc] == goal) { // 미로찾기 성공
					result = 1;
					return;
				}
				if (tmpMap[nr][nc] == 0) {
					tmpMap[nr][nc] = 1;
					runMaze(nr, nc);
					tmpMap[nr][nc] = 0;
					
				}
			}
		}
	}
}
