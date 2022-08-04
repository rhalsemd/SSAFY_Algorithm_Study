import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1966
class Pair{
	int key, val;
	public Pair(int key, int val) {
		this.key = key; this.val = val;
	}
}
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Integer[] arr = new Integer[n];
			Queue<Pair> que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			int val = 0;
			for(int i=0; i<n; i++) {
				if(i==m) val = 1;
				else val = 0;
				int key = Integer.parseInt(st.nextToken());
				que.add(new Pair(key, val));
				arr[i] = key;
			}
			Arrays.sort(arr, Collections.reverseOrder());
			boolean found = false;

			int i=0;
			while(true) {
				while(true) {
					Pair item = que.poll();
					if(item.key == arr[i]) {
						i++;
						if(item.val == 1) {
							found=true;
							break;
						}
					}
					else que.add(item);
				}
				if(found) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
