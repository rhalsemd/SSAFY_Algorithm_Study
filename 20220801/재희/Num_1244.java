import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//스위치 켜고 끄기
class Student {
	int gender; // 남학생 1, 여학생 2
	int index; // 자신이 받은 index

	public Student(int gender, int index) {
		super();
		this.gender = gender;
		this.index = index;
	}
}

public class Num_1244{

	static char[] switchInput = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int switchSize = Integer.parseInt(br.readLine());
		switchInput = br.readLine().replaceAll(" ", "").toCharArray();
		int studentSize = Integer.parseInt(br.readLine());

		Student[] students = new Student[studentSize];
		for (int i = 0; i < studentSize; i++) {
			String[] tmp = br.readLine().split(" ");
			int gender = Integer.parseInt(tmp[0]);
			int index = Integer.parseInt(tmp[1]);
			students[i] = new Student(gender, index);
			changeSwitch(students[i]);
		}

		int cnt = 0;
		for (int i = 0; i < switchSize; i++) {
			if(cnt == 20) {
				bw.write("\n");
				cnt = 0;
			}
			bw.write(switchInput[i] + " ");
			cnt++;
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void changeSwitch(Student s) {
		if (s.gender == 1)
			forMan(s.index);
		else
			forWoman(s.index);
	}

	public static void forMan(int index) { // 남자용 연산
		int i = index - 1, j = 1;

		while (i < switchInput.length) {
			switchInput[i] = switchInput[i] == '1' ? '0' : '1'; // toggle
			i = index * (++j) - 1;
		}
	}

	public static void forWoman(int index) { // 여자용 연산
		int start = index - 1, end = index - 1;
		
		while(true) {
			if(start <= 0 | end >= switchInput.length-1)
				break;
			
			if (switchInput[start-1] == switchInput[end+1]) {
				start--;
				end++;
			}
			else if(switchInput[start-1] != switchInput[end+1])
				break;
		}

		for (int i = start; i <= end; i++) {
			switchInput[i] = switchInput[i] == '1' ? '0' : '1'; // toggle
		}
	}
}
