import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//트리의 부모 찾기
public class BJ_11725 {
	static int N;
	static List<Integer>[] adjList;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N+1];
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			parents[i] = i;
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		bfs(1);
		
		for(int i=2; i<=N; i++) {
			bw.write(parents[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int root) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(root);
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			for(int i=0, size=adjList[parent].size(); i<size; i++) {
				int value = adjList[parent].get(i);
				if(visited[value]) continue;
				visited[value] = true;
				parents[value] = parent;
				q.offer(value);
			}
//			for(int i=0, qSize = q.size(); i<qSize; i++) {
//			}
		}
	}
}
