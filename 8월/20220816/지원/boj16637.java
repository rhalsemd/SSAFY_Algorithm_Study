package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	public static int n;
	public static List<Character> oper=new ArrayList<>();
	public static List<Integer> nums=new ArrayList<>();
	public static int ans=Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String word = br.readLine();
		for (int i = 0; i < n; i++) {
			if ((i + 1) % 2 == 1) {
				nums.add(Character.getNumericValue(word.charAt(i)));
			} else {
				oper.add(word.charAt(i));
			}
		}
		recur(nums.get(0), 0);
		System.out.println(ans);
	 
	}

	public static int cal(int n1, int n2, char oper) {
		if(oper=='+') return n1+n2;
		else if(oper=='-') return n1-n2;
		else  return n1*n2;
	 
		 
	}

	public static void recur(int result, int idx) {
		if (idx == oper.size()) {
			ans=Math.max(ans,result);
			return;
		}
		recur(cal(result, nums.get(idx + 1), oper.get(idx)), idx + 1);
		if (idx <= oper.size() - 2) {
			int num = cal(nums.get(idx + 1), nums.get(idx + 2), oper.get(idx + 1));
			recur(cal(result,num, oper.get(idx)), idx + 2);
		}
	 
	}

}
