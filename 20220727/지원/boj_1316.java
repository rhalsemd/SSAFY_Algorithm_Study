import java.util.*;

public class Main {
	 
	public static boolean isGroup(String word) {
		List <String> list=new ArrayList<>();
		char before=word.charAt(0);
		String temp="";
		temp+=Character.toString(word.charAt(0));
		for(int i=1;i<word.length();i++) {
			if(before==word.charAt(i)) {
				temp+=Character.toString(word.charAt(i));
			}
			else {
				before=word.charAt(i);
				list.add(temp);
				temp=Character.toString(word.charAt(i));
				 				 
			}
			 
		}
		list.add(temp);
		
		Set <Character> set=new HashSet<>();		
		for(String n:list) {
			set.add(n.charAt(0));
		}
		if (set.size()==list.size()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		 
		 Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
		 
		 int count=0;
		 for(int i=0;i<n;i++) {
			 String word=sc.next();
			 if(isGroup(word)) {
				 count+=1;
			 }
		 }
		 System.out.println(count);
		 
		
		 
		
	}

}
