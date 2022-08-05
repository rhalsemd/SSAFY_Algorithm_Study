package ws0805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//DNA 비밀번호
class SubsetOption{
	int aCnt = 0, cCnt = 0, gCnt = 0, tCnt = 0;
	int tmpACnt = 0, tmpCCnt = 0, tmpGCnt = 0, tmpTCnt = 0;
	
	public SubsetOption(int aCnt, int cCnt, int gCnt, int tCnt) {
		super();
		this.aCnt = aCnt; tmpACnt = 0;
		this.cCnt = cCnt; tmpCCnt = 0;
		this.gCnt = gCnt; tmpGCnt = 0;
		this.tCnt = tCnt; tmpTCnt = 0;
	}
	
	public void cancelUseSubset(char dna) {
		switch(dna) {
		case 'A' : tmpACnt--; break;
		case 'C' : tmpCCnt--; break; 
		case 'G' : tmpGCnt--; break; 
		case 'T' : tmpTCnt--; break; 
 		}
	}

	public void useSubset(char dna) {
		switch(dna) {
		case 'A' : tmpACnt++; break;
		case 'C' : tmpCCnt++; break; 
		case 'G' : tmpGCnt++; break; 
		case 'T' : tmpTCnt++; break; 
 		}
	}
	
	public boolean isPassword() {
		if(tmpACnt>=aCnt && tmpCCnt>=cCnt && tmpGCnt>=gCnt && tmpTCnt>=tCnt) {
			return true;
		}
		return false;
	}
}
public class BJ_Num_12891 {
	static int S;			//임의의 dna 문자열
	static int P;			//부분집합 갯수
	static char[] subset;	//부분집합
	
	static int subsetCnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String sizeStr = br.readLine();
		StringTokenizer st = new StringTokenizer(sizeStr, " ");
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		subset = new char[P];
		
		char[] input = br.readLine().toCharArray();
		String cntStr = br.readLine();
		st = new StringTokenizer(cntStr, " ");
		
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		SubsetOption option = new SubsetOption(a,c,g,t);
		
		for(int i=0; i<P; i++) {
			option.useSubset(input[i]);
		}
		if(option.isPassword())
			subsetCnt++;
		
		for(int i=1; i<S-P+1; i++) {
			char forward = input[i+P-1];
			option.useSubset(forward);
			char backward = input[i-1];
			option.cancelUseSubset(backward);
			if(option.isPassword()) {
				subsetCnt++;
			}
		}
		
		bw.write(subsetCnt + "");
		bw.flush();
		bw.close();
	}
}
