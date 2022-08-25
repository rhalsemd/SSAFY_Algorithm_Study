package swexpert_20220825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s8382 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int T=Integer.parseInt(st.nextToken());
	        
	        for(int t=1;t<T+1;t++) {
	        	st = new StringTokenizer(br.readLine());
	        	int startx =Integer.parseInt(st.nextToken());
	        	int starty =Integer.parseInt(st.nextToken());
	        	int endx=Integer.parseInt(st.nextToken());
	        	int endy=Integer.parseInt(st.nextToken());
	        	
	        	 int xd = Math.abs(startx-endx);
	             int yd = Math.abs(starty-endy);
	             int diff = Math.abs(xd-yd);
	             int ans = (Math.min(xd,yd) * 2) + diff*2 - diff%2;
	             System.out.println("#"+t+" "+ans);
	        }
	}

}
