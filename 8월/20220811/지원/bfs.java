import java.util.*;
import java.io.*;
public class Solution {
    public static int [][] graph;
    public static boolean [][] visited;
    public static int [] dx= {-1,1,0,0};
    public static int [] dy= {0,0,-1,1};
    public static void main(String [] args) throws Exception{
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           
         for(int tc=1;tc<=10;tc++) {
              
             br.readLine();
             graph=new int[100][100];
             visited=new boolean[100][100];
             for(int i=0;i<100;i++) {
                 String line=br.readLine();
                 for(int j=0;j<100;j++)
                     graph[i][j]=line.charAt(j)-'0';
             }
             int ans=bfs();
             System.out.println("#"+tc+" "+ans);
         }
 
         
    }
    public static int bfs() {
         
        visited[1][1]=true;
        Queue <int []> q=new LinkedList<>();
        q.add(new int [] {1,1});
        while (!q.isEmpty()) {
            int [] info=q.poll();
            for(int i=0;i<4;i++) {
                int nx=info[0]+dx[i];
                int ny=info[1]+dy[i];
                if(nx>=0 &&ny>=0&&nx<100&&ny<100) {
                    if(visited[nx][ny]==false&&graph[nx][ny]==0) {
                        visited[nx][ny]=true;
                        q.add(new int [] {nx,ny});
                    }
                    if(graph[nx][ny]==3) return 1;
                }
            }
        }
        return 0;
         
    }
      
  
}
