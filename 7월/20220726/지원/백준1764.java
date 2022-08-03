import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		Map <String,Boolean> notHear=new HashMap<>();
		Map <String,Boolean> notSee=new HashMap<>();
		Set <String> names=new HashSet<>();
		List <String> notHearAndSee=new ArrayList<>();
		for(int i=0;i<n;i++) {
			String name=sc.next();
			notHear.put(name, true);
			names.add(name);
		}
		
		for(int i=0;i<m;i++) {
			String name=sc.next();
			notSee.put(name, true);
			names.add(name);
		}
		
		int count=0;
		for(String name:names) {
			if(notSee.getOrDefault(name,false)==true && notHear.getOrDefault(name,false)==true) {
				notHearAndSee.add(name);
				count+=1;
			}
		}
		System.out.println(count);
		Collections.sort(notHearAndSee);
		for(String name:notHearAndSee) {
			System.out.println(name);
		}
		
	}

}
