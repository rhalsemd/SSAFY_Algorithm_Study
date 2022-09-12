import java.util.*;
import java.io.*;
public class Main {

	static Map <Integer,Integer>map=new HashMap<>();
	public static void main(String[] args) throws Exception{
		 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		 
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			map.put(x, y);
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			map.put(u, v);
		}
		
		int [] graph=new int[101];
		Arrays.fill(graph, Integer.MAX_VALUE);
	 
		Queue <int []> q=new LinkedList<>(); //칸 번호,몇번만에 왔는지 
		q.add(new int [] {1,0});
		graph[1]=0;
		while(!q.isEmpty()) {
			int [] now=q.poll();
			
			 
			if(map.getOrDefault(now[0], -1)!=-1) {
				 int nextNum=map.getOrDefault(now[0], -1);
				 if(graph[nextNum]>now[1]) {
					 graph[nextNum]=now[1];
					 q.add(new int [] {nextNum,now[1]});
				 }
			}
			else {
				for(int i=1;i<=6;i++) {
					int nextNum=now[0]+i;
					if(nextNum>100) continue;
					 
					if(graph[nextNum]>now[1]+1) {
						graph[nextNum]=now[1]+1;
						q.add(new int [] {nextNum,now[1]+1});
					}
				 
				}
			}
		}
		System.out.println(graph[100]);
	}
	 
}
