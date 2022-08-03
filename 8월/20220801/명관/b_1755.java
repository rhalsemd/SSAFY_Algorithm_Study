package baekjoon_20220801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class b_1755 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		Comparator<String> comparator = (s1, s2)->s1.compareTo(s2);
		Map<String,Integer> sortedmap = new TreeMap<>(comparator);
		String [] num = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
		for (int i = Integer.parseInt(s[0]); i <= Integer.parseInt(s[1]); i++) {
			if(i/10!=0) {
				sortedmap.put(num[i/10]+" "+num[i%10], i);
			}
			else {
				sortedmap.put(num[i%10], i);
			}
		}
		Integer[] key = sortedmap.values().toArray(new Integer[0]);
		for(int i=0;i<key.length;i++) {
			if(i%10==0&&i>0) {
				System.out.println();
			}
			System.out.print(key[i]+" ");
		}
	}
}
