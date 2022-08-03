package baekjoon_20220726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baeckjoon10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[][] ha = new String[N][2]; 
		for (int i = 0; i < N; i++) {
			String a = bf.readLine();
			String[] b = a.split(" ");
			ha[i][0] = b[0];
			ha[i][1] = b[1];
		}
		Arrays.sort(ha,new Comparator<String[]>(){
            @Override
            public int compare(String[] a, String[] b){
                return Integer.compare(Integer.parseInt(a[0]),Integer.parseInt(b[0]));
            }
        });
        
        for(int i=0; i<N; i++){
            System.out.println(ha[i][0] +" "+ ha[i][1]);
        }
    }
		
}
