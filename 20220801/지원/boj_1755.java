import java.util.*;
//BJ 1244-스위치 켜고 끄기
import java.io.*;
public class Main {
	 
	public static void main(String[] args) throws Exception{
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  String [] input=br.readLine().split(" ");
		  ArrayList <String> arr=new ArrayList<>();
		  char [] numberChar= {'1','2','3','4','5','6','7','8','9','0'};
		  String [] numberStr= {"one","two","three","four","five","six","seven","eight","nine","zero"};
		  HashMap<String,String> strToNum=new HashMap<>(); //키: 문자열, 값:숫자
		  HashMap<Character,String> numToStr=new HashMap<>(); //키: 숫자, 값:문자열
		  
		  
		  for(int i=0;i<numberChar.length;i++) {
			  numToStr.put(numberChar[i],numberStr[i]);
		  }
		  
		  for(int i=Integer.parseInt(input[0]);i<=Integer.parseInt(input[1]);i++) {
			  String number=String.valueOf(i);
			  String temp="";
			  for(int j=0;j<number.length();j++) {
				  temp+=numToStr.get(number.charAt(j));
			  }
			  arr.add(temp);
			  strToNum.put(temp,number);
		  }
		  Collections.sort(arr);
		  
		  for(int i=0;i<arr.size();i++) {
			  if(i!=0&&i%10==0) {
					 System.out.println();
				}
			  System.out.print(strToNum.get(arr.get(i))+" ");
		  }
		  
		   
		  
		
	}

}
