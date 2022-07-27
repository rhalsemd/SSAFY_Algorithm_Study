package baekjoon_20220727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(bf.readLine());
		int [][] arr = new int[a][2];
		for(int i=0; i<arr.length;i++) {
			String[] xy = bf.readLine().split(" ");
			arr[i][1] = Integer.parseInt(xy[0]);
			arr[i][0] = Integer.parseInt(xy[1]);
		}
		for(int i=0; i<arr.length;i++) {
			
		}
		Arrays.sort(arr, (a1, a2) -> {
			if(a1[0] == a2[0]) {
				return a1[1] - a2[1];
			} else {
				return a1[0] - a2[0];
			}
		});
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i][1]+" "+arr[i][0]);
		}
	}

}
