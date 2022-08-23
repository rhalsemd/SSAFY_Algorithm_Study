import java.util.*;
import java.io.*;
 
public  class Main {
	 
	static int [][] sky;
	static int [][] ground;
	static int n,m;
	static int [] dx= {0,-1,-1,-1,0,1,1,1};
	static int [] dy= {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		sky=new int[n+1][n+1];
		ground=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			 st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				ground[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		sky[n][1]=1;
		sky[n][2]=1;
		sky[n-1][1]=1;
		sky[n-1][2]=1;
		for(int i=0;i<m;i++) {
			 st=new StringTokenizer(br.readLine());
			  
			 int d=Integer.parseInt(st.nextToken());
			 int s=Integer.parseInt(st.nextToken());
			 moveCloud(d,s); //구름이동
			 rain(); //비오고 
			 magic(); //물복사
			 makeCloud(); //새 구름 생김
			 
		}
		System.out.println(getWater());
		 
	}
	public static void moveCloud(int d, int s) {
		List <int []> list=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(sky[i][j]==1) {
					list.add(movePos(i,j,d,s));
				}
			}
		}
		
		for(int [] arr:list) {
			sky[arr[0]][arr[1]]=1;
		}
	}
	public static int [] movePos(int x, int y,int d,int s) {
		sky[x][y]=0;
		for(int i=0;i<s;i++) {
			x=x+dx[d-1];
			y=y+dy[d-1];
			if(x==0) x=n;
			if(x==n+1) x=1;
			
			if(y==0) y=n;
			if(y==n+1) y=1;
			
		}
		return new int [] {x,y};
	}
	public static void rain() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(sky[i][j]==1) {
					ground[i][j]+=1;  	 
				}
			}
		}
	}
	public static void magic() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(sky[i][j]==1) { 
					ground[i][j]+=countNear(i,j);//물복사버그 
				}
			}
		}
	}
	public static int countNear(int x,int y) {
		int count=0;
		for(int i=1;i<=7;i+=2) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=1&&ny>=1&&nx<=n&&ny<=n&&ground[nx][ny]>=1) count++;
		}
		return count;
	}
	public static void makeCloud() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(ground[i][j]>=2&&sky[i][j]!=1) sky[i][j]=2;
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(sky[i][j]==1) sky[i][j]=0;
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(sky[i][j]==2) {
					sky[i][j]=1;
					ground[i][j]-=2;
					}
			}
		}
		
	}
	public static int getWater() {
		int res=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				res+=ground[i][j];
			}
		}
		return res;
	}
	 
	 
}
