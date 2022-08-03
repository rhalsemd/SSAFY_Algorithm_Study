package baekjoon_20220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] tmp = br.readLine().split("");
			int sum=0;
			for (int j = 0; j < tmp.length; j++) {
				if(tmp[j].equals("(")) {
					sum+=1;
				}
				else if(tmp[j].equals(")")) {
					sum -=1;
				}
				if(sum<0) {
					System.out.println("NO");
					break;
				}
			}
			if(sum>0) {
				System.out.println("NO");
			}
			else if(sum==0) {
				System.out.println("YES");
			}
		}
	}

}
