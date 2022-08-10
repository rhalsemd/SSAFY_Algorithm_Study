import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Command {
	int r, c, s;

	public Command(int r, int c, int s) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

//배열 돌리기4
public class Num_17406 {
	static int N, M, Ksize;
	static int arr[][];
	static int tmp[][];
	static int resultMin = Integer.MAX_VALUE;
	static Command[] cmds;
	static Command[] selectedCmds;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstLine = br.readLine().split(" ");
		N = Integer.parseInt(firstLine[0]);
		M = Integer.parseInt(firstLine[1]);
		Ksize = Integer.parseInt(firstLine[2]);

		arr = new int[N][M];
		cmds = new Command[Ksize];
		selectedCmds = new Command[Ksize];
		isSelected = new boolean[Ksize];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		for (int i = 0; i < Ksize; i++) {		//회전 값 받기
			String[] command = br.readLine().split(" ");
			int r = Integer.parseInt(command[0]);
			int c = Integer.parseInt(command[1]);
			int s = Integer.parseInt(command[2]);

			cmds[i] = new Command(r, c, s);
		}
		perm(0);

		bw.write(resultMin + "\n");
		bw.flush();
		bw.close();

	}// end of main

	static void perm(int cnt) {
		if (cnt == Ksize) {
			tmp = new int[N][M];
			for(int i=0; i<N; i++)
				for(int j=0; j<M; j++)
					tmp[i][j] = arr[i][j];
			
			for(int k=0; k<Ksize; k++) {
				rotateArr(selectedCmds[k]);
			}
			
			int min = calculMin();
			resultMin = Math.min(min, resultMin);
			return;
		}
		for (int i = 0; i < cmds.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				selectedCmds[cnt] = cmds[i];
				perm(cnt + 1);
				isSelected[i] = false;
			}
		}
	}
	public static void rotateArr(Command cmd) {
			int startX = cmd.r - cmd.s - 1;
			int startY = cmd.c - cmd.s - 1;
			int endX = cmd.r + cmd.s - 1;
			int endY = cmd.c + cmd.s - 1;
			int groupCnt = Math.min(endX - startX, endY - startY) / 2; //그룹으로 나눠서 회전
			
			for(int g=0; g<groupCnt; g++) {
				int val = tmp[startX+g][startY+g];
				for(int j=startX+g; j<endX-g; j++) //왼쪽
					tmp[j][startY+g] = tmp[j+1][startY+g];
				
				for(int j=startY+g; j<endY-g; j++) //아래쪽
					tmp[endX-g][j] = tmp[endX-g][j+1];
				
				for(int j=endX-g; j>startX+g; j--) //오른쪽
					tmp[j][endY-g] = tmp[j-1][endY-g];
				
				for(int j=endY-g; j>startY+g; j--) //위쪽
					tmp[startX+g][j] = tmp[startX+g][j-1];
				
				tmp[startX+g][startY+g+1] = val;
			}
	}
	
	static int calculMin() {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<M; j++)
				cnt += tmp[i][j];
			min = Math.min(cnt, min);
		}
		return min;
	}
}
