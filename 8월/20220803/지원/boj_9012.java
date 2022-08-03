import java.util.*;
import java.io.*;
public class Main  {
	 
	public static void check(String input) {
		Stack<Character> stack = new Stack<>(); 
		for(int i=0;i<input.length();i++) {
			if (input.charAt(i)=='(') {
				stack.add('(');
			}
			else {
				if(stack.size()==0) {
					System.out.println("NO");
					return;
				}
				else {
					stack.pop();
				}
			}
		}
		if (stack.size()==0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	public static void main(String[] args) throws Exception{
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  int n=Integer.parseInt(br.readLine());
		   
		  for(int i=0;i<n;i++) {
			  String input=br.readLine();
			  check(input); 
		  }
		   
	}		
}
