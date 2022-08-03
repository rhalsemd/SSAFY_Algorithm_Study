import java.util.*;
 
import java.io.*;
public class Main {
	 
	public static void main(String[] args) throws Exception{
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  String word=br.readLine();
		  ArrayList<String> arr=new ArrayList<>();
		  
		  int n=word.length();
		  char [] chararr=new char[n];
		  
		  char before=word.charAt(0);
		  String temp="";
		  temp+=before;
		  for(int i=1;i<n;i++) {
			   if(before==word.charAt(i)) {
				   temp+=word.charAt(i);
			   }
			   else {
				   arr.add(temp);
				   temp="";
				   temp+=word.charAt(i);
			   }
			   before=word.charAt(i);
		  }
		  arr.add(temp);
		  
		  char target=word.charAt(0);
		  int count=0;
		  for(String num:arr) {
			  if(target!=num.charAt(0)) {
				  count+=1;
			  }
		  }
		  System.out.println(count);
		  
		   
		  
		
	}

}
