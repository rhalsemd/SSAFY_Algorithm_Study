package study20221017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1238 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int[][] dist = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++)
	           Arrays.fill(dist[i], 1000000);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b]=c;
		}
		//학생(i)가 이동하는 경로는 i -> X -> i이다. 따라서 이동하는데 걸리는 시간은 (i -> X) + (X -> i)
		for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
        int ans = 0;
        for (int i = 1; i <= N; i++)
            if (i != X)
                ans = Math.max(ans, dist[i][X] + dist[X][i]);

        System.out.println(ans);
	}

}
