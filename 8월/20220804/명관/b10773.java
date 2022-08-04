package baekjoon_20220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	Stack<Integer> s = new Stack<>();
    	for (int i = 0; i < T; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a!=0) {
				s.push(a);
			}
			else if(a==0){
				s.pop();
			}
    	}
    	int sum=0;
    	for (int i :s) {
			sum+=i;
		}
    	System.out.println(sum);
	}

}
