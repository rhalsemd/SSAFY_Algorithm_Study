import java.util.*;
import java.io.*;
public class Main  {
	  
	public static void main(String[] args) throws Exception{
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  int n=Integer.parseInt(br.readLine());
		  Stack <Integer> stack=new Stack<>();
		  int m;
		  for(int i=0;i<n;i++) {
			  m=Integer.parseInt(br.readLine());
			  if(m==0) {
				  stack.pop();
			  }
			  else {
				  stack.add(m);
			  }
			 
		  }
		  int answer=0;
		  for(int num:stack) {
			  answer+=num;
		  }
		  System.out.println(answer);
	}		
}
