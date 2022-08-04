package baekjoon_20220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1966 {
	static int T; 
	static int N;
	static int M; 
	static Queue<Integer> queue; 
	static Queue<Integer> indexQueue; 
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < T; i++) {    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());

    		queue = new LinkedList<>();
    		indexQueue = new LinkedList<>();
    		
    		st = new StringTokenizer(br.readLine());
    		
    		for(int j = 0; j < N; j++) {
    			queue.offer(Integer.parseInt(st.nextToken()));
    			indexQueue.offer(j);
    		}
    		
    		solve();
    	}
    }
    public static void solve() {
    	int count = 1; 
    	while (!queue.isEmpty()) {
    		int max = Collections.max(queue); 
    		int cur = queue.poll();
    		int curIndex = indexQueue.poll(); 
    		if(cur == max) {
    			if(curIndex == M) {
    				System.out.println(count);
    				break;
    			}
    			count++; 
    		}
    		else {
    			queue.offer(cur);
    			indexQueue.offer(curIndex);
    		}
    	}
    }
}