package baekjoon_20220802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b_1213 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//선언 및 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String name = br.readLine();
		String answer = "";
		int[] cnt = new int[26];
		int odd_cnt=0;
		int midIdx = -1;
		for(int i=0;i<name.length();i++) {
			cnt[name.charAt(i)-'A']++;
		}
		for(int i=0;i<cnt.length;i++) {
			if(cnt[i]%2!=0) {
				midIdx = i;
				odd_cnt++;
			}
		}
		if((name.length()%2!=0 && odd_cnt>1)||(name.length()%2==0 && odd_cnt>0))
			System.out.println("I'm Sorry Hansoo");
		else {
			for(int i=0;i<26;i++) {
				for(int j=0;j<cnt[i]/2;j++)
					answer+=(char)(i+'A');
			}
			String rev = (new StringBuffer(answer)).reverse().toString();
			if(odd_cnt==1)
				answer+=(char)(midIdx+'A');
			answer+=rev;
			System.out.println(answer);
		}
		
	}

}