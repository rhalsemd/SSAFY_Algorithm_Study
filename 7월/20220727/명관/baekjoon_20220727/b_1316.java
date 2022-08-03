package baekjoon_20220727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int N = Integer.parseInt(br.readLine());
		int count = N;
		boolean[] a = new boolean[26];
		for(int i = 0; i < N; i++)
		{
			String str = br.readLine();
			Arrays.fill(a, false);			
			a[str.charAt(0) - 97] = true;
			for(int j = 1; j < str.length(); j++)
			{
				if(str.charAt(j) != str.charAt(j - 1)) {
					if(a[str.charAt(j) - 97] == true) {
						count--;
						break;
					}
					else {
						a[str.charAt(j) - 97] = true;
					}
				}					
			}
		}
		System.out.print(count);
	}
}
