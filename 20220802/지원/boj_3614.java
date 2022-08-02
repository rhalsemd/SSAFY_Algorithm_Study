package backjoon;

import java.util.*;
 
import java.io.*;
public class Main {
	 
	public static boolean isError(String word) {
		if(word.contains("_")&&checkJava(word)) {
			  return true;
		 }
		if(word.charAt(0)=='_') {
			return true;
		}
		if(word.charAt(word.length()-1)=='_') {
			return true;
		}
		if(word.contains("__")) {  
			return true;
		}
		if(Character.isUpperCase(word.charAt(0))) {
			return true;
		}
		return false;
	}
	public static boolean checkJava(String word) {
		for(int i=0;i<word.length();i++) {
			if(Character.isUpperCase(word.charAt(i)))
				return true;
		}
		return false;
	}
	public static void cToJava(String word) {
		ArrayList <String> arr=new ArrayList<>();
		String [] temp=word.split("_");
		System.out.print(temp[0]);
		for(int i=1;i<temp.length;i++) {
			String w=Character.toString(temp[i].charAt(0)).toUpperCase()+temp[i].substring(1);
			System.out.print(w);
		}
		 
	}
	public static void javaToC(String word) {
		ArrayList <String> arr=new ArrayList<>();
		String temp="";
		for(int i=0;i<word.length();i++) {
			if(Character.isUpperCase(word.charAt(i))) {
				arr.add(temp);
				temp=Character.toString(word.charAt(i)).toLowerCase();
			}
			else {
				temp+=Character.toString(word.charAt(i));	
			}
			  
		}
		arr.add(temp); 
		for(int i=0;i<arr.size()-1;i++) {
			System.out.print(arr.get(i)+"_");
		}
		System.out.print(arr.get(arr.size()-1));
	}
	public static void main(String[] args) throws Exception{
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  String word=br.readLine();
		  if(isError(word)) {
			   System.out.println("Error!");
		  }
		  else if(word.contains("_")) {
			  cToJava(word);
		  }
		  else if(checkJava(word)) {
			  javaToC(word);
		  }
		  else {
			  System.out.println(word);
		  }
		   
		  
		
	}

}
