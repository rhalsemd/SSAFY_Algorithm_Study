import java.util.*;

public class Main {
	 
	public static int getDifference(int startIndex,String a,String b) {
		int count=0;
		int aIndex=0;
		for(int bIndex=startIndex;bIndex<b.length();bIndex++) {
			if(aIndex>=a.length()) break;
			if(a.charAt(aIndex)!=b.charAt(bIndex)) {
				count+=1;
			}
			aIndex+=1;
		}
		return count;
	}
	public static void main(String[] args) {
		 
		 Scanner sc=new Scanner(System.in);
		 String a=sc.next();
		 String b=sc.next();
		 
		 //각 경우 A와B 차이 저장
		 List <Integer> result=new ArrayList<>();
		 
		 for(int i=0;i<b.length()-a.length()+1;i++) {
			 result.add(getDifference(i,a,b));
		 }
		 Collections.sort(result);
		 System.out.println(result.get(0));
		 
		 
		
	}

}
