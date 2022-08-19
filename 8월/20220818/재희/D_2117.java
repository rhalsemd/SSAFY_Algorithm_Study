import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D_2117 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 하나의 집이 지불할 수 있는 비용

			ArrayList<Integer> HX = new ArrayList<Integer>();
			ArrayList<Integer> HY = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (st.nextElement().equals("1")) {
						HX.add(i);
						HY.add(j);
					}
				}
			}

			int H = HX.size();
			int result = 0; 	// 최대 집수
			for (int K = N+1; K > 0; K--) { 		//서비스 영역 내의 가장 큰 정사각형이 맵의 크기가 되는 k까지 고려해봄
				int cost = K * K + (K - 1) * (K - 1);

				for (int X = 0; X < N; X++) {
					for (int Y = 0; Y < N; Y++) {	// X,Y는 서비스 영역의 정 중앙이라고 생각함, 영역이 맵을 벗어나더라도 상관없으니 가능
						int cnt = 0; // 포함되는 집 수
						for (int i = 0; i < H; i++) {
							if (Math.abs(HX.get(i) - X) + Math.abs(HY.get(i) - Y) < K) {	//서비스 영역을 벗어나는지 확인
								cnt++;
							}
						}
						if (cnt * M >= cost) {
							result = cnt > result ? cnt : result;
						}
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}
