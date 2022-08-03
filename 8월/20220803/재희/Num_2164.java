import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Num_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer>  deque = new LinkedList<>();
		for(int i=n; i>=1; i--) {
			deque.addLast(i);
		}
		
		while(deque.size()>1) {
			deque.pollLast();
			int tmp = deque.pollLast();
			deque.addFirst(tmp);
		}
		bw.write(deque.pollLast() + "");
		bw.flush();
		bw.close();
	} 
}
