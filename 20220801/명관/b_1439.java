package baekjoon_20220801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1439 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int num[];
		num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        int zeroCnt = 0;
        int oneCnt = 0;
        int prevNum = -1;
        for (int i = 0; i < num.length; i++) {
            int count_num = num[i];
            if (count_num != prevNum) {
                if (count_num == 0) {
                    zeroCnt++;
                } else { //1
                    oneCnt++;
                }
            }
            prevNum = count_num;
        }
        System.out.println(Math.min(zeroCnt, oneCnt));
	}

}
