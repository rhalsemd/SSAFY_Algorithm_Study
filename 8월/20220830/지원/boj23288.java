import java.util.*;
import java.io.*;

public class Main {
 
	static class Dice{
		int [] figure; 
		int [] temp=new int[6];
		int x;
		int y;
		public Dice(){
			figure=new int [] {2,4,1,3,5,6};
			x=0;
			y=0;
		}
		
		public void rollRight(int x, int y) { //동3
			setTemp();
			figure[1]=temp[5];
			figure[2]=temp[1];
			figure[3]=temp[2];
			figure[5]=temp[3];
			this.x=x;
			this.y=y;
			 
		}
		public void rollLeft(int x, int y) { //서2
			setTemp();
			figure[1]=temp[2];
			figure[2]=temp[3];
			figure[3]=temp[5];
			figure[5]=temp[1];
			this.x=x;
			this.y=y;
		}
		
		public void rollDown(int x, int y) { //남1
			setTemp();
			figure[0]=temp[5];
			figure[2]=temp[0];
			figure[4]=temp[2];
			figure[5]=temp[4];
			this.x=x;
			this.y=y;
			
		}
		
		public void rollUp(int x, int y) { //북0
			setTemp();
			figure[0]=temp[2];
			figure[2]=temp[4];
			figure[4]=temp[5];
			figure[5]=temp[0];
			this.x=x;
			this.y=y;
		}
		public void setTemp() {
			for(int i=0;i<6;i++)
				temp[i]=figure[i];
		}
		public int getBottomNumber() {
			return figure[5];
		}
		
	}
	static int [][] graph;
	static int n,m,k,ans;
	static int direction;
	
	//북,남,서,동
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,-1,1};
	static Queue <int []> q=new LinkedList<>();
	static Dice dice;
	static boolean [][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		direction=3;
		ans=0;
		dice=new Dice();
		graph=new int[n][m];
		visited=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<k;i++) {
			roll(dice.x,dice.y);
			getScore();
			 
		}
		System.out.println(ans);
		 
	}
	public static void roll(int x,int y ) {
		int nx=x+dx[direction];
		int ny=y+dy[direction];
		
		if(nx<0||ny<0||nx>=n||ny>=m) {
			direction=getReverseDir(direction);
			nx=x+dx[direction];
			ny=y+dy[direction];
		}
		//북 남 서 동
		if(direction==0) dice.rollUp(nx,ny);
		else if (direction==1) dice.rollDown(nx,ny);
		else if (direction==2) dice.rollLeft(nx, ny);
		else dice.rollRight(nx, ny);
		
		setNextDir();
	}
	
	public static void setNextDir() {
		int a=dice.getBottomNumber();
		int b=graph[dice.x][dice.y];
		if(a>b) direction=rotate(0); //시계
		else if(a<b) direction=rotate(1);
	}
	
	public static int rotate(int type) {
		if(type==0) {
			if(direction==0) return 3;
			if(direction==3) return 1;
			if(direction==1) return 2;
			if(direction==2) return 0;
		}
		else {
			if(direction==0) return 2;
			if(direction==2) return 1;
			if(direction==1) return 3;
			if(direction==3) return 0;
		}
		return 0;
	}
	public static int getReverseDir(int dir ) {
		if(dir==0) return 1;
		else if(dir==1) return 0;
		else if(dir==2) return 3;
		else return 2;
		 
	}
	 
	 
	public static void getScore() {
		clear();
		int count=1;
		visited[dice.x][dice.y]=true;
		q.add(new int [] {dice.x,dice.y});
		int num=graph[dice.x][dice.y];
		while(!q.isEmpty()) {
			int [] pos=q.poll();
			for(int i=0;i<4;i++) {
				int nx=pos[0]+dx[i];
				int ny=pos[1]+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(!visited[nx][ny]&&graph[nx][ny]==num) {
						visited[nx][ny]=true;
						q.add(new int [] {nx,ny});
						count++;
					}
				}
			}
		}
		int score=count*num;
		ans+=score;
	}
	public static void clear() {
		q.clear();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				visited[i][j]=false;
		}
	}
	
	
	 
 
}
