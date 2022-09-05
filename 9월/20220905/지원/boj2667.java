import java.util.*;
public class Main {

	static int map [][];
	static boolean visited [][];
	
	//0위치를 엇갈리게 해야 for문 돌면서 체크할때 상하좌우를 하나씩 살펴볼 수 있다.
	static int dr []= {-1,+1,0,0}; //좌우(가로열)을 살핀다.
	static int dc []= {0,0,-1,+1}; //상하(세로열)을 살핀다.
	
	static int n;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 n=sc.nextInt();
		 map=new int[n][n];
		 visited  =new boolean[n][n];
		
		
		for(int i=0;i<n;i++) {
			String input=sc.next(); //한줄씩입력되고, 띄어쓰기는 없음
			for(int j=0;j<n;j++) {
				map[i][j]=input.charAt(j)-'0';
				visited[i][j]=false;
			}
		}
		//단지 내 집의 수를 줄줄히 넣을 arraylist
		ArrayList <Integer> arr =new ArrayList<>();
		
		for(int i=0;i<n;i++) {		 
			 
			for(int j=0;j<n;j++) {
				//이 if문에 걸린다면, 어떤 단지 내의 집을 처음 발견한 것임.
				//이미 발견된 단지 내에서 처음보는 집이라면, search 재귀 호출 중에 체크될것이기 때문
				 if(map[i][j]==1&&visited[i][j]==false) {
					 count=1; //단지 내 첫번째 집이므로 count도 1로 바꿔준다.
					 Search(i,j);
					 arr.add(count);
					 
				 }
			}
		}
		
		Collections.sort(arr);
		int num=arr.size(); //단지 수
		System.out.println(num);
		for(int i=0;i<num;i++) {
			System.out.println(arr.get(i));
		}
	
		 
			 			 
		 	 
	}
	//dfs 재귀호출로 하자 
	public static void Search(int i, int j) {
		visited[i][j]=true; //일단 들어온 애를 트루로 만들고,
		for(int k=0;k<4;k++) {
			 int nx=i+dr[k];
			 int ny=j+dc[k];
			 //인덱스 범위를 벗어난다면 볼필요 없음
			 if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				 if(map[nx][ny]==1&&visited[nx][ny]==false) {
					 Search(nx,ny);
					 count++;
				 }
			 }
		}
		
	}
}
