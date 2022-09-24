package baekjoon_20220922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663 {
	static int cnt = 0;
    static int N;
    //안에 들어가 있는 수는 column이고 각 자리는 row를 의미
    static int[] queen;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queen = new int[N];
		dfs(0);
		System.out.println(cnt);
	}

	static void dfs(int depth) {
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			queen[depth] = i;
			if (canPut(depth))
				dfs(depth + 1);
		}
	}

	// 여왕이 자리에 들어갈 수 있는지를 판단하는 함수
	static boolean canPut(int depth) {
		for (int i = 0; i < depth; i++) {
			if (queen[depth] == queen[i])
				return false;
			else if (Math.abs(depth - i) == Math.abs(queen[depth] - queen[i]))
				return false;
		}
		return true;
	}
}