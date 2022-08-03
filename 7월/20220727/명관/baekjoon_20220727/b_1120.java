package baekjoon_20220727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		String a = s.nextToken();
		String b = s.nextToken();
		int ans = a.length();
		
		for (int i = 0; i <= b.length()-a.length(); i++) {
			int t = 0 ;
			for (int j = 0; j < a.length(); j++) {
				if(a.charAt(j)!=b.charAt(j+i)) {
					t++;
				}
			}
			ans = Math.min(ans, t);
		}
		System.out.println(ans);
	}
}