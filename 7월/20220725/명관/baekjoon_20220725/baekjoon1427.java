package baekjoon_20220725;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class baekjoon1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] input_arr = new String[input.length()];
		for(int i=0;i<input.length();i++) {
			input_arr[i]=input.substring(i, i+1);
		}
		Arrays.sort(input_arr, Collections.reverseOrder());
		for(int i=0;i<input.length();i++) {
			System.out.print(input_arr[i]);
		}
	}

}
