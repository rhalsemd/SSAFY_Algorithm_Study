import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BJ_16637 {
	static int N;
	static int[] numbers;
	static char[] operations;
	static boolean[] selected;
	static int maxResult = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		numbers = new int[N / 2 + 1];
		operations = new char[N / 2];
		selected = new boolean[N/2];

		String input = br.readLine();
		int numCnt = 0, opCnt = 0;

		for (int i = 0; i < N; i++) {
			char c = input.charAt(i);
			switch (c) {
			case '-':
			case '+':
			case '*': operations[opCnt++] = c; break;
			default:  numbers[numCnt++] = c - '0';
			}
		}

		subset(0);
		bw.write(maxResult + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static void subset(int cnt) {
		if (cnt == N/2) {
			if(!ruleCheck()) return;
			
			List<Integer> numTmp = new ArrayList<>();
			for(int i=0; i<N/2+1; i++) {
				numTmp.add(numbers[i]);
			}
			List<Character> opTmp = new ArrayList<>();
			for(int i=0; i<N/2; i++) {
				opTmp.add(operations[i]);
			}
			List<Boolean> selectedTmp = new ArrayList<>();
			for(int i=0; i<N/2; i++) {
				selectedTmp.add(selected[i]);
			}
			
			//계산
			for(int i=0; i<opTmp.size(); i++) {
				if(selectedTmp.get(i)) {		//우선순위가 있으면 먼저 계산
					char op = opTmp.get(i);
					int value = 0;
					if(op=='+') {
						value = numTmp.get(i)+numTmp.get(i+1);
					}
					else if(op=='-') {
						value = numTmp.get(i)-numTmp.get(i+1);
					}
					else if(op=='*') {
						value = numTmp.get(i)*numTmp.get(i+1);
					}
					opTmp.remove(i);
					numTmp.set(i, value);
					numTmp.remove(i+1);
					selectedTmp.remove(i);
					i--;
				}
			}
			
			for(int i=0; i<opTmp.size(); i++) {		//우선 순위가 없는 연산자들 계산
				char op = opTmp.get(i);
				int value = 0;
				if(op=='+') {
					value = numTmp.get(i)+numTmp.get(i+1);
				}
				else if(op=='-') {
					value = numTmp.get(i)-numTmp.get(i+1);
				}
				else if(op=='*') {
					value = numTmp.get(i)*numTmp.get(i+1);
				}
				opTmp.remove(i);
				numTmp.set(i, value);
				numTmp.remove(i+1);
				selectedTmp.remove(i);
				i--;
			}
			maxResult = Math.max(numTmp.get(0), maxResult);
			return;
		} //end of 기저

		selected[cnt] = true;
		subset(cnt+1);
		
		selected[cnt] = false;
		subset(cnt+1);
	}
	
	static boolean ruleCheck() {
		for(int i=0; i<N/2-1; i++) {
			if(selected[i]) {
				if(selected[i+1]) return false;
			}
		}
		return true;
	}
}
