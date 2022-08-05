import java.util.*;
import java.io.*;

public class Main {
	static List<Integer> laser = new ArrayList<>();
	static List<int[]> stick = new ArrayList<>();
	static int laserNum=0;
	static int stickNum=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		// stack.add(new int [] {1,2});
		String input = br.readLine();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				stack.add(i);
			} else {
				int startIndex = stack.pop();
				if (i - startIndex == 1) {
					laser.add(startIndex);
					laserNum+=1;
				}
				else {
					stick.add(new int[] { startIndex, i });
					stickNum+=1;
				}

			}
		}
		int ans=0;
		for(int i=0;i<stickNum;i++) {
			ans+=howMany(i);
		}
		System.out.println(ans);
		

	}

	public static int howMany(int index) {
		int [] temp=stick.get(index);
		int count=1;
		for(int i=0;i<laserNum;i++) {
			int pos=laser.get(i);
			if(pos>temp[0]&&pos<temp[1]) count++;
		}
		 
		return count;
	}
}
