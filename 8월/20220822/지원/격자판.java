import java.io.*;
import java.util.*;
 
  
public class Solution {
     
    static Set <String> set=new HashSet<>(); 
    static int [][] graph;
    static int [] dx= {-1,1,0,0};
    static int [] dy= {0,0,-1,1};
    public static void main(String[] args) throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         int TC=Integer.parseInt(br.readLine());
         for(int tc=1;tc<=TC;tc++) {
             graph=new int[4][4];
             set.clear();
             for(int i=0;i<4;i++) {
                 StringTokenizer st=new StringTokenizer(br.readLine());
                 for(int j=0;j<4;j++)
                     graph[i][j]=Integer.parseInt(st.nextToken());
             }
             for(int i=0;i<4;i++) {
                 for(int j=0;j<4;j++) {
                     dfs(i,j,"");
                 }
             }
               
             System.out.println("#"+tc+" "+set.size());
         }
    }
    public static void dfs(int x, int y,String word) {
        if(word.length()==7) {
            set.add(word);
            return;
        }
        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(isAble(nx,ny)) dfs(nx,ny,word+String.valueOf(graph[nx][ny]));
        }
         
    }
    public static boolean isAble(int x,int y) {
        if(x>=0&&y>=0&&x<4&&y<4) return true;
        return false;
    }
}
