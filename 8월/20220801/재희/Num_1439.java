import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//뒤집기
public class Num_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] input = br.readLine().toCharArray();
		
		List<String> zeroArr = new ArrayList<>();	//연속된 0 배열
		List<String> oneArr = new ArrayList<>(); 	//연속된 1 배열
		boolean current = true;
		boolean isZero = true;
		int cnt = 1;			//input의 첫글자가 무엇이든 그것을 기준으로 1로 시작
		
		if(input[0]=='1') {
			isZero = false;
			current = false;
		}

		for(int i=1; i<input.length; i++) {
			isZero = input[i] == '1' ? false : true;	//1이면 false, 0이면 true
			
			if(current != isZero){	// 0에서 1로 바뀜 or 1에서 0으로 바뀐 경우
				if(current) { 	//0이 계속 된 만큼 list에 추가
					char[] tmp = Arrays.copyOfRange(input, i-cnt, i) ;
					zeroArr.add(tmp.toString());
				}	
				else {			//1이 계속 된 만큼 list에 추가
					char[] tmp = Arrays.copyOfRange(input, i-cnt, i) ;
					oneArr.add(tmp.toString());
				}
				cnt = 1;
			}
			else{
				cnt++;
				
			}
			current = isZero;
		}
		
		int result = Math.max(zeroArr.size(), oneArr.size());
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
}
// 11001100110011000001
