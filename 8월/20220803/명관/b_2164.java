package baekjoon_20220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=T;i++) {
			q.add(i);
		}
		while(q.size()!=1) {
			q.remove();
			int tmp=q.peek();
			q.remove();
			q.add(tmp);
		}
		System.out.println(q.peek());
	}

}
