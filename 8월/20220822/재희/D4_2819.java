import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

//격자판의 숫자 이어 붙이기
public class D4_2819 {
	static Set<String> numbers;
	static int result;
	static char[][] map;
	static char[] selectedNums;
	
	static int[] dr = {-1, 1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			numbers = new HashSet<>();
			result = 0;
			map = new char[4][4];
			selectedNums = new char[7];
			
			for(int i=0; i<4; i++) {
				char[] input = br.readLine().replaceAll(" ", "").toCharArray();
				map[i] = input;
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					selectedNums[0] = map[i][j];
					search(i, j, 1);
				}
			}
			
			bw.write("#" + t + " " + numbers.size() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void search(int r, int c, int cnt) {
		if(cnt==7) {
			numbers.add(new String(selectedNums));
			return;
		}
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >=0 && nc>=0 && nr<4 && nc<4) {		//범위를 벗어나지 않으면
				selectedNums[cnt] = map[nr][nc];
				search(nr, nc, cnt+1);
			}
		}
	}
}
