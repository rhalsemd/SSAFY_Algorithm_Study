import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

//나이순 정렬
class Person{
	int age;
	String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
}
public class Num_10814 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arrSize = Integer.parseInt(br.readLine());
		Person[] ps = new Person[arrSize];
		
		for(int i=0; i<arrSize; i++) {
			String[] tmp = br.readLine().split(" ");
			ps[i] = new Person(Integer.parseInt(tmp[0]), tmp[1]);
		}
		
		Arrays.sort(ps, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		
		for(int i=0; i<arrSize; i++) {
			bw.write(String.format("%d %s\n", ps[i].age, ps[i].name));
		}
		bw.flush();
		bw.close();
	}
}
