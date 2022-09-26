package backjoon;

import java.util.*;
import java.io.*;

public class Main {
  
	static int [][] person;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		person= new int[n][2];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			person[i][0]=a;
			person[i][1]=b;
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(check(i)+" ");
		}
		 
		
		
		 
	}
	public static int check(int k) {
		int count=0;
		
		for(int i=0;i<n;i++) {
			if(i==k) continue;
			if(person[i][0]>person[k][0] && person[i][1]>person[k][1]) count++;
		}
		return count+1;
	}
	 
}
