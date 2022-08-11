// 구미 5반 한상우

package ws0810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class CalcData {
	public int r;
	public int c;
	public int s;

	public CalcData() {
	}

	public CalcData(int r, int c, int s) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class BOJ_17406_HW {
	public static int rowSize;
	public static int colSize;
	public static int calcCnt;
	public static int result = (int) (1e9);
	public static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		calcCnt = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[rowSize + 1][colSize + 1];
		int[][] memory = new int[rowSize + 1][colSize + 1];
		CalcData[] data = new CalcData[calcCnt];
		isSelected = new boolean[calcCnt];

		for (int x = 1; x <= rowSize; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 1; y <= colSize; y++) {
				matrix[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < calcCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			CalcData temp = new CalcData();
			temp.r = Integer.parseInt(st.nextToken());
			temp.c = Integer.parseInt(st.nextToken());
			temp.s = Integer.parseInt(st.nextToken());
			data[i] = temp;
		}

		CalcData[] selectedCalc = new CalcData[calcCnt];
		permutation(matrix, memory, data, selectedCalc, 0);

		System.out.println(result);

	}

	public static void permutation(int[][] matrix, int[][] memory, CalcData[] calcData, CalcData[] selectedCalc,
			int cnt) {
		if (cnt == calcCnt) {
			rotate(matrix, memory, selectedCalc, calcCnt);
			return;
		}

		for (int i = 0; i < calcCnt; i++) {
			if (isSelected[i])
				continue;
			selectedCalc[cnt] = calcData[i];
			isSelected[i] = true;
			permutation(matrix, memory, calcData, selectedCalc, cnt + 1);
			isSelected[i] = false;
		}
	}

	public static void rotate(int[][] matrix, int[][] memory, CalcData[] calcData, int rotateCnt) {
		deepCopy(matrix, memory);
		for (CalcData calc : calcData) {
			int minX = calc.r - calc.s;
			int maxX = calc.r + calc.s;
			int minY = calc.c - calc.s;
			int maxY = calc.c + calc.s;

			int rowSize = maxX - minX + 1;
			int colSize = maxY - minY + 1;

			int x, y;
			for (int i = 0; (i < (rowSize / 2) && i < (colSize / 2)); i++) {
				int temp = memory[minX][maxY];

				x = minX;
				for (y = maxY; y >= minY + 1; y--) {
					memory[x][y] = memory[x][y - 1];
				}

				y = minY;
				for (x = minX; x <= maxX - 1; x++) {
					memory[x][y] = memory[x + 1][y];
				}

				x = maxX;
				for (y = minY; y <= maxY - 1; y++) {
					memory[x][y] = memory[x][y + 1];
				}

				y = maxY;
				for (x = maxX; x >= minX + 1; x--) {
					memory[x][y] = memory[x - 1][y];
				}

				memory[minX + 1][maxY] = temp;

				minX++;
				minY++;
				maxX--;
				maxY--;
			}
		}

		for (int x = 1; x <= rowSize; x++) {
			int temp = 0;
			for (int y = 1; y <= colSize; y++) {
				temp += memory[x][y];
			}

			if (temp < result)
				result = temp;
		}

	}

	public static void deepCopy(int[][] src, int[][] dest) {
		for (int i = 0; i < src.length; i++) {
			System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
		}
	}
}
