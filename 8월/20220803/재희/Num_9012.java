import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Num_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();

		for(int t=0; t<tc; t++) {
			boolean isSuccess = true;
			stack = new Stack<>();
			char[] tmp = br.readLine().toCharArray();
			for(int i=0; i<tmp.length;i++) {		//input
				if(tmp[i]=='(')
					stack.push(tmp[i]);
				else {
					if(stack.isEmpty()) {
						isSuccess = false;
						break;
					} 
					stack.pop();
				}
			}
			if(!isSuccess | !stack.isEmpty()) 	bw.write("NO" + "\n");
			else 								bw.write("YES" + "\n");
		}
		bw.flush();
		bw.close();
	}
}
