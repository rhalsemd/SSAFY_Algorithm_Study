import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Num_1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		char[] a = s[0].toCharArray();
		char[] b = s[1].toCharArray();
		Map<Integer, Integer> diff = new HashMap<>();	//index, 차이값 쌍
		
		for(int i=0; i<= b.length-a.length; i++) {
			int diffCnt = 0;
			for(int j=0; j<a.length; j++) {
				if(b[i+j]!=a[j])
					diffCnt++;
			}
			diff.put(i, diffCnt);
		}
		
		int min = diff.get(0);
		for(int i=1; i<diff.size(); i++) {
			int n = diff.get(i);
			if(min > n)
				min = n;
		}
		
		System.out.println(min);
	}
}
