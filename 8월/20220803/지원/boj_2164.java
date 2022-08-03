import java.util.*;
import java.io.*;
public class Main  {
	 
	public static void main(String[] args) throws Exception{
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  int n=Integer.parseInt(br.readLine());
		  Queue <Integer> queue=new LinkedList<>();
		  for(int i=1;i<=n;i++) {
			  queue.add(i);
		  }
		  int card=0;
		  while (true) {
			  card=queue.poll();
			  if(queue.isEmpty()) break;
			  int next=queue.poll();
			  queue.add(next);
		  }
		  System.out.println(card);
	}		
}
