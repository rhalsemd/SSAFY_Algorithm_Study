package mock_exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class SWEA_2117 {
	public static int[][] map;
	public static int[][] visited;
	public static int size;
	public static int price;
	public static int result = 0;

	public static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			size = Integer.parseInt(st.nextToken());
			price = Integer.parseInt(st.nextToken());
			map = new int[size][size];
			visited = new int[size][size];

			for (int r = 0; r < size; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < size; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					if (map[r][c] == 1)
						BFS(r, c, 1);
					else
						BFS(r, c, 0);
					visited = new int[size][size];
				}
			}
			resultString.append('#').append(testCase).append(' ').append(result).append('\n');
		}
		System.out.println(resultString);
	}

	public static void BFS(int x, int y, int houseCnt) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(x, y));
		visited[x][y] = 1;
		int k = 0;
		int expense;
		int revenue;

		while (!queue.isEmpty()) {
			k++;
			expense = k * k + (k - 1) * (k - 1);
			revenue = houseCnt * price;
			if ((revenue - expense) >= 0)
				result = Math.max(result, houseCnt);

			int queueSize = queue.size();
			while (--queueSize >= 0) {
				Node node = queue.poll();
				int r = node.r;
				int c = node.c;

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (0 <= nr && nr < size && 0 <= nc && nc < size) {
						if (visited[nr][nc] == 1)
							continue;
						if (map[nr][nc] == 1)
							houseCnt++;
						visited[nr][nc] = 1;
						queue.offer(new Node(nr, nc));
					}
				}
			}
		}

	}

}
