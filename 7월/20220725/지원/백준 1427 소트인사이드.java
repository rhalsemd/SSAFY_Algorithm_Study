import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 
		String num=sc.next();
		char [] charArr=num.toCharArray();
		Arrays.sort(charArr);
		
		for(int i=num.length()-1;i>=0;i--) {
			System.out.print(charArr[i]);
		}
		
	}

}
