package baekjoon_20220726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class baekjoon1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		String[] arr = str.split(" ");
		int N = Integer.parseInt(arr[0]); 
		int M = Integer.parseInt(arr[1]);
		Set<String> noli = new HashSet<String>();
		for(int i=0;i<N;i++) {
			noli.add(bf.readLine());
		}
		List<String> ls = new ArrayList<>();
		String tmp;
		for(int i=0;i<M;i++) {
			tmp = bf.readLine();
			if(noli.contains(tmp)) {
				ls.add(tmp);
			}
		}
		Collections.sort(ls);
		System.out.println(ls.size());
		for(String s : ls) {
			System.out.println(s);
		}
	}
}
