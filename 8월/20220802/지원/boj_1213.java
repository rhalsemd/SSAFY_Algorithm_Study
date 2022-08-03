import java.util.*;
 
public class Main  {
	 
	
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 String word=sc.next ();
		 HashMap <String,Integer>map=new HashMap<>();
		 ArrayList <String> canuse=new ArrayList<>();
		 for(int i=0;i<word.length();i++) {
			 String k=Character.toString(word.charAt(i));
			 int n=map.getOrDefault(k, 0);
			 n+=1;
			 map.put(k, n );
			 if(n >=2) {
				 canuse.add(k);
				 n-=2;
				 map.put(k, n );
			 }
		 }
		 String mid="";
		 for(String key:map.keySet()) {
			 if(map.get(key)==1&&mid.equals("")) {
				 mid=key;
			 }
			 else if(map.get(key)==1&&!mid.equals("")) {
				 System.out.println("I'm Sorry Hansoo");
				 return;
			 }
		 }
		 Collections.sort(canuse);
		 
		 for(int i=canuse.size()-1;i>=0;i--) {
			 mid= canuse.get(i)+mid+canuse.get(i);
		 }
		 System.out.println(mid);
	}		
}
