package s0727.ex1316;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			String word = sc.next();
			int len = word.length();
			int[] dup = new int['z'-'a'+1]; // 26개는 0 ~ 25라서 +1 필요 
			
			dup[word.charAt(0)-'a']++;
			
			boolean checker = true;
			for(int j=1; j<len; j++) {
				if(word.charAt(j) != word.charAt(j-1)){
					if(dup[word.charAt(j)-'a'] > 0) {
						checker=false;
						break;
					}
				}
				dup[word.charAt(j)-'a']++;
			}
			if(checker) answer++;
		}
		System.out.println(answer);
		
	}
}
