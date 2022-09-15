package baekjoon_20220916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b12865 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int[][] o = new int[count+1][max+1];
		
		for(int i = 1; i < count+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j < max+1; j++) {
				if(j < weight) {
				
					o[i][j] = o[i-1][j];
				}
				else {
					o[i][j] = Math.max(o[i-1][j], o[i-1][j-weight] + value);
				}
			}
		}
		bw.write(o[count][max] + "\n");
		bw.flush();
		bw.close();	
	}
}