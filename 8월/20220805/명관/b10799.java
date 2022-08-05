package baekjoon_20220805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class b10799 {

	 public static void main(String[] args) throws NumberFormatException, IOException {
	        // TODO Auto-generated method stub
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        String input = bf.readLine();
	        Stack<Character> stack = new Stack<>();
	 
	        int result = 0;
	        for (int i = 0; i < input.length(); i++) {
	            if (input.charAt(i) == '(') {
	                stack.push('(');
	                continue;
	            }
	            if (input.charAt(i) == ')') { 
	                stack.pop(); 
	 
	                if (input.charAt(i - 1) == '(') { 
	                    result += stack.size(); // 현재 stack의 사이즈만큼 더해 줌.
	                } else { //
	                    result++; 
	                }
	            }
	        }
	 
	        bw.write(result + "\n");
	        bw.flush();
	        bf.close();
	        bw.close();
	    }
	 
}
