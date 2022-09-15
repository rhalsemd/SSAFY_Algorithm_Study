package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int [] W=new int[101];
		int [] V=new int[101];
		
		int [][] dp=new int[n+1][k+1];		 
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			W[i]=w;
			V[i]=v;
		}
 
		for(int item=1;item<=n;item++) {
			for(int kg=1;kg<=k;kg++) {
				if(W[item]>kg) dp[item][kg]=dp[item-1][kg];
				else dp[item][kg]=Math.max(dp[item-1][kg], V[item]+dp[item-1][kg-W[item]]);
			}
		}
		
		 
         
        System.out.println(dp[n][k]);

	}

}
