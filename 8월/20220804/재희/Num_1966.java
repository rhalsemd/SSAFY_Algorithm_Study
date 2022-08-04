import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Document{
	int index;		//입력될때 부여받는 index
	int prior;		//우선순위 값
	
	public Document(int index, int prior) {
		super();
		this.index = index;
		this.prior = prior;
	}
}
public class Num_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			String[] tmp = br.readLine().split(" ");
			int size = Integer.parseInt(tmp[0]);	//문서 사이즈
			int wantToKnow = Integer.parseInt(tmp[1]);	//원하는 문서 인덱스
			
			Queue<Document> que = new LinkedList<>();			//출력용
			Queue<Document> anotherQue = new LinkedList<>();	//우선순위를 정리할때 잠시 옮겨놓는 용
			
			char[] priors = br.readLine().replaceAll(" ", "").toCharArray();
			for(int i=0; i<size; i++) {
				que.add(new Document(i, priors[i] -'0'));
			}
			int cnt = 0;
			int maxPrior = 0;
			while(true) {
				Document print = que.remove();
				maxPrior = print.prior;
				
				while(!que.isEmpty()) {				//print가 가장 큰 우선순위인지 검사
					Document move = que.remove();
					anotherQue.add(move);
					if(move.prior > maxPrior)
						maxPrior = move.prior;
				}
				while(!anotherQue.isEmpty()) {		//원위치
					que.add(anotherQue.remove());
				}
				
				if(maxPrior > print.prior) {		//print가 출력될 순서가 아니라면 맨 뒤로
					que.add(print);
				}		
				else {								//출력하고 카운트
					cnt++;
					if(print.index == wantToKnow)	//내가 원하는 index의 문서가 출력되었다면 테스트 종료
						break;
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
	}
}
