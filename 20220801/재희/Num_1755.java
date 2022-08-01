import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//숫자놀이
class Number{
	String toString;	//규칙에 맞춰서
	int toInteger;		//숫자로 표현
	public Number(String toString, int toInteger) {
		super();
		this.toString = toString;
		this.toInteger = toInteger;
	}
}

public class Num_1755 {
	static String[] engNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] chs = br.readLine().split(" ");
		int start = Integer.parseInt(chs[0]);
		int end = Integer.parseInt(chs[1]);
		List<Number> list = new ArrayList<>();
		
		for(int i=start; i<=end; i++) {
			String tmp = intToEngNum(i);
			list.add(new Number(tmp, i));
		}
		
		list.sort((i1, i2)-> i1.toString.compareTo(i2.toString));
		
		int cntNextLine = 0;
		int cnt = 0;
		while(cnt < list.size()) {
			if(cntNextLine==10) {
				bw.write('\n');
				cntNextLine = 0;
			}
			bw.write(list.get(cnt++).toInteger + " ");
			cntNextLine++;
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static String intToEngNum(int c) {
		StringBuilder sb = new StringBuilder();
		char[] cs = Integer.toString(c).toCharArray();
		
		for(int i=0; i<cs.length; i++) {
			sb.append(engNums[Integer.parseInt(cs[i] + "")]);
		}
		return sb.toString();
	}
}
