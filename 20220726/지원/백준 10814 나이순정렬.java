import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringBuilder[] sb = new StringBuilder[201];
		String [] info=new String[201];
		Set <Integer> ages=new HashSet<>();
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			int age=sc.nextInt();
			String name=sc.next();
			if(info[age]==null) {
				info[age]=age+" "+name+"\n";
			}
			else {
				info[age]+=age+" "+name+"\n";
			}
			ages.add(age);
			 
		}
		
		List<Integer> list=new ArrayList<>(ages);
		Collections.sort(list); //오름차순 정렬
		
		for(int age: list) {
			System.out.print(info[age]);
		}
		 
	}

}
