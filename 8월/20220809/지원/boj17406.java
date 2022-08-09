import java.util.*;
import java.io.*;

 
public class Main {
 
		public static int [] output;
		public static boolean [] visited;
		public static int [][] graph;
		public static int [][] originGraph;
		public static List <int []> orders=new ArrayList<>();
		public static List <int []> rotateInfo=new ArrayList<>();
		public static void main(String [] args) throws Exception{
			
			 //------입출력 및 사전세팅------
			 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			 String [] NMK=br.readLine().split(" ");
			 int n=Integer.parseInt(NMK[0]);
			 int m=Integer.parseInt(NMK[1]);
			 int k=Integer.parseInt(NMK[2]);
			 graph=new int[n][m];
			 originGraph=new int[n][m];
			 output=new int[k]; //순열 계산 위한 배열1
			 visited=new boolean[k]; //순열 계 위한 배열2
			 int answer=Integer.MAX_VALUE;
			 perm(0,k);  
			 for(int i=0;i<n;i++) {
				 String [] temp=br.readLine().split(" ");
				 for(int j=0;j<m;j++)  {
					 graph[i][j]=Integer.parseInt(temp[j]);
					 originGraph[i][j]=graph[i][j];
				 }
			 }
			 for(int i=0;i<k;i++) {
				 String [] temp=br.readLine().split(" ");
				 int [] arr=new int[3];
				 for(int j=0;j<3;j++) {
					 arr[j]=Integer.parseInt(temp[j]);
				 }
				 rotateInfo.add(arr);
			 }
			//------회전 및 계산------
		 	 for(int [] orderInfo:orders) {
				for(int index:orderInfo) {
					int x1=rotateInfo.get(index)[0]-rotateInfo.get(index)[2]-1;
					int y1=rotateInfo.get(index)[1]-rotateInfo.get(index)[2]-1;
					int x2=rotateInfo.get(index)[0]+rotateInfo.get(index)[2]-1;
					int y2=rotateInfo.get(index)[1]+rotateInfo.get(index)[2]-1;
					rotate(x1,y1,x2,y2);
				}
				 
				answer=Math.min(answer,getArrVal(n,m));
				clearGraph(n,m);
			}  
		 	 System.out.println(answer);
		}
		
		public static void perm(int count,int k) {
			if(count==k) {
				int [] res=new int[k];
				for(int i=0;i<k;i++) {
					res[i]=output[i];
				}
				orders.add(res);
			}
			for(int i=0;i<k;i++) {
				if(visited[i]==false) {
					visited[i]=true;
					output[count]=i;
					perm(count+1,k);
					visited[i]=false;
				}
			}		 
		}
		 
		public static void rotate (int x1, int y1, int x2, int y2) {
			if(x1>=x2 || y2<=y1) return;
			else {
				 
				List <Integer> list=new ArrayList<>();
				for(int i=y1;i<=y2;i++) list.add(graph[x1][i]);
				for(int i=x1+1;i<=x2;i++)list.add(graph[i][y2]);
				for(int i=y2-1;i>=y1;i--)list.add(graph[x2][i]);
				for(int i=x2-1;i>=x1+1;i--)list.add(graph[i][y1]);
			
				list.add(0,graph[x1+1][y1]);
				int index=0;
				for(int i=y1;i<=y2;i++) graph[x1][i]=list.get(index++);
				for(int i=x1+1;i<=x2;i++) graph[i][y2]=list.get(index++);
				for(int i=y2-1;i>=y1;i--) graph[x2][i]=list.get(index++);
				for(int i=x2-1;i>=x1+1;i--) graph[i][y1]=list.get(index++);
				//안쪽의 줄 회전
				rotate(x1+1,y1+1,x2-1,y2-1);
			}
		}
		public static int getArrVal(int n,int m) {
			int res=Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				int sum=0;
				for(int j=0;j<m;j++) sum+=graph[i][j];
				res=Math.min(sum, res);
			}
			return res;
		}
		public static void clearGraph(int n,int m) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					graph[i][j]=originGraph[i][j];
				}
			}
			
		}
	 
	 

}
