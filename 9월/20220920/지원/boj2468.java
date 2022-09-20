import java.util.*;
import java.io.*;

class Main {
  static int [][] graph;
  static int [][] originGraph;
  static boolean [][] visited;
  static int n;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n=Integer.parseInt(br.readLine());
    int maxH=0;
    graph=new int[n][n];
    originGraph=new int[n][n];
    visited=new boolean[n][n];
    
    StringTokenizer st;
    for(int i=0;i<n;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0;j<n;j++){
        graph[i][j]=Integer.parseInt(st.nextToken());
        originGraph[i][j]=graph[i][j];
        maxH=Math.max(graph[i][j],maxH);
      }
    }

    int ans=0;
    for(int i=0;i<=maxH;i++){
      ans=Math.max(bfsReady(i),ans);
    }
    System.out.println(ans);
 
  }
  public static int bfsReady(int h){
     
    rain(h);
    int count=0;

    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(graph[i][j]!=0&&visited[i][j]==false){
          bfs(i,j);
          count++;
        }
      }
    }
    reset();
    return count;
  }
  static int [] dx={-1,1,0,0};
  static int [] dy={0,0,-1,1};
  public static void bfs(int sx,int sy){
    Queue <int []>q=new LinkedList<>();
    q.add(new int [] {sx,sy});
    visited[sx][sy]=true;

    while(!q.isEmpty()){
      int [] pos=q.poll();

      for(int i=0;i<4;i++){
        int nx=pos[0]+dx[i];
        int ny=pos[1]+dy[i];
        if(nx>=0&&ny>=0&&nx<n&&ny<n){
          if(visited[nx][ny]==false&&graph[nx][ny]!=0){
            visited[nx][ny]=true;
            q.add(new int [] {nx,ny});
          }
        }
      }
    }
    
  }
  public static void rain(int h){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(graph[i][j]<=h){
          graph[i][j]=0;
        }
      }
    }
  }
  public static void reset(){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        graph[i][j]=originGraph[i][j];
        visited[i][j]=false;
      }
    }
  }
}
