package s0727.ex11651;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {  // 오름차순 o1 - o2 = - 
				if(o1[1] != o2[1]) return o1[1] - o2[1];
				else return o1[0] - o2[0];  // x 오름차순 
			}
		});
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i][0] + " "+ arr[i][1]);
		}
	}
}
