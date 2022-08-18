import java.util.*;
import java.io.*;
 
public class Solution {
   
    static int [][] graph;
    static int n,m,ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //maxK=가로너비+2
        int TC=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=TC;tc++) {
            String [] info=br.readLine().split(" ");
            n=Integer.parseInt(info[0]);
            m=Integer.parseInt(info[1]);
            ans=0;
            graph=new int[n][n];
            for(int i=0;i<n;i++) {
                String [] line=br.readLine().split(" ");
                for(int j=0;j<n;j++) {
                    graph[i][j]=Integer.parseInt(line[j]);
                }
            }
            dfs(n+2);
            System.out.println("#"+ tc+" "+ans);
         
        }
      
    }
    //크기가 k일때  서비스할 수 있는 집개수
    public static void dfs(int k) {
        if(k==0) {
            return;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int cnt=coloring(i,j,k);
                int money=k*k+(k-1)*(k-1);
                if(cnt*m-money>=0) {
                    ans=Math.max(ans, cnt);
                }
            }
        }
        dfs(k-1);
         
    }
    //x,y를 중심으로 k인 마름모를 펼쳤을때 커버되는 집의 수
    public static int coloring(int x,int y,int k)
    {
        int cnt=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                //마름모 안칠하고 거리로 비교해도 ok
                if(Math.abs(x-i)+Math.abs(y-j)<k &&graph[i][j]==1) cnt++;
            }
        }
          
        return cnt;
    }
      
  
}
