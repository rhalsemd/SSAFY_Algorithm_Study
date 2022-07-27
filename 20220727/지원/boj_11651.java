import java.util.*;

public class Main {
	 	 
	public static void main(String[] args) {
		 
		 Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
		 int [][] info=new int [n][2];
		 for(int i=0;i<n;i++) {
			 info[i][0]=sc.nextInt();
			 info[i][1]=sc.nextInt();
		 }
		 
		 Arrays.sort(info, (o1,o2)->{
			 //y값이 같으면 x값 기준으로
			 if(o1[1]==o2[1]) {
				 return o1[0]-o2[0];
			 }
			 else {
				 return o1[1]-o2[1]; 
			 }
		 });
		 
		for(int i=0;i<n;i++) {
			System.out.println(info[i][0]+" "+info[i][1]);
		}
		 
		
		 
		
	}

}
