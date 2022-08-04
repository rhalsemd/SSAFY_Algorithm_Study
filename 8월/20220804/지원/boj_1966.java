package backjoon;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String [] args) throws Exception{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		// 큐에 배열로 넣을땐 연결리스트-연결리스트로 구현하는게 편하다.
		 LinkedList<int[]> q = new LinkedList<>();	 
 
		 int T=Integer.parseInt(br.readLine());
		 StringBuilder sb=new StringBuilder();
		 for(int tc=1;tc<=T;tc++) { 
			 String [] temp=br.readLine().split(" ");
			 int n=Integer.parseInt(temp[0]);
			 int index=Integer.parseInt(temp[1]);
			 String [] arr=br.readLine().split(" ");
			 q.clear();
			 Integer [] order=new Integer[n];
			 for(int i=0;i<n;i++) {
				 //중요도,위치
				 q.add(new int[] {Integer.parseInt(arr[i]), i,i});  
				 order[i]=Integer.parseInt(arr[i]);
			 }
			 int count=0;
			 Arrays.sort(order, Collections.reverseOrder());
			  
			  while(true) {
				 int [] doc=q.poll();
				 //뽑은게 현재 가장 높은 우선도면 큐에서 뺀다.
				 if (doc[0]==order[count]) {
					order[count]=0;
					count+=1; 
					if(doc[1]==index) break;
				 }
				 else {
					 q.add(doc);
				 }
			 }
			 sb.append(count +"\n"); 
			  		  
		 }
		 System.out.println(sb);
	}
	 
	 
}
