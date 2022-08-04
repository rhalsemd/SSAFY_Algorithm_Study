import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Num_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int lineSize = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int sum = 0;
		for(int i=0; i<lineSize; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				sum -= stack.pop();
				continue;
			}
			stack.push(n);
			sum += n;
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
