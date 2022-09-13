package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int parents[];
	static List<Integer> list[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		// 배열의 한 원소가 어레이리스트
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		parents = new int[n + 1];  
		bfs();
		for (int i = 2; i < n + 1; i++) {
			System.out.println(parents[i]);
		}

	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		parents[1] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int next : list[temp]) {
				// 방문x
				if (parents[next] == 0) {
					q.offer(next);
					parents[next] = temp;

				}
			}

		}

	}
}
