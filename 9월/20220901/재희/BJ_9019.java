import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DSLR
public class BJ_9019 {
	static int A, B;
	static String[] cmds;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			cmds = new String[10000];
			visited = new boolean[10000];
			
			String res = bfs();
			bw.write(res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static String bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(A);
		cmds[A] = Integer.toString(A);
		Arrays.fill(cmds, "");
		visited[A] = true;

		while(!q.isEmpty()) {
			for(int i=0, size=q.size(); i<size; i++) {
				int now = q.poll();
				
				int D = (now*2)%10000;
				int S = now==0 ? 9999 : now-1;
				int L = (now%1000)*10 + now/1000;
				int R = (now%10)*1000 + now/10;
				
				if(!visited[D]) {
					q.add(D);
					visited[D] = true;
					cmds[D] = cmds[now] + "D";
				}
				if(!visited[S]) {
					q.add(S);
					visited[S] = true;
	                cmds[S] = cmds[now] + "S";
				}
				if(!visited[L]) {
					q.add(L);
					visited[L] = true;
	                cmds[L] = cmds[now] + "L";
				}
                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    cmds[R] = cmds[now] + "R";
                }
			}
		}
		return cmds[B];
	}
	
	static boolean isSame(int a) {
		return a==B;
	}
}
