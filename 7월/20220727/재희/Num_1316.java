import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Word{
	char[] word;
	List<Character> groups = new ArrayList<>();
	
	public Word(char[] word) {
		this.word = word;
	}
	
	public boolean checkGroupsWord() {
		char c = word[0];
		groups.add(c);
		
		for(int i=1; i<word.length; i++) {
			boolean isThere = groups.contains(word[i]);
			
			if(word[i] == c)
				continue;
			else if(word[i] != c && isThere) {
				return false;
			}
			else if(word[i]!=c && !isThere) {
				c = word[i];
				groups.add(word[i]);
			}
				
		}
		return true;
	}
}

public class Num_1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int wordCnt = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=0; i<wordCnt; i++) {
			boolean check = new Word(br.readLine().toCharArray()).checkGroupsWord();
			if(check)
				result++;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
