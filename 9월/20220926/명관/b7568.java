package baekjoon_20220926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b7568 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> weight_list = new ArrayList<>();
		List<Integer> height_list = new ArrayList<>();
		List<Integer> rank_list = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());	
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			weight_list.add(Integer.parseInt(st.nextToken()));
			height_list.add(Integer.parseInt(st.nextToken()));
			rank_list.add(N);
		}

		for(int i=0; i<N; i++) {
			int weight = weight_list.get(i);
			int height = height_list.get(i);

			for(int j=i+1; j<N; j++) {
				int weight2 = weight_list.get(j);
				int height2 = height_list.get(j);

				if(weight > weight2) {
					if(height > height2) {
						rank_list.set(i, rank_list.get(i) - 1);
					}
					else {

						rank_list.set(i, rank_list.get(i) - 1);
						rank_list.set(j, rank_list.get(j) - 1);
					}
				}
				else if(weight < weight2) {

					if(height < height2) {
						rank_list.set(j, rank_list.get(j) - 1);
					}
					else {

						rank_list.set(i, rank_list.get(i) - 1);
						rank_list.set(j, rank_list.get(j) - 1);
					}
				}
				else if(weight == weight2) {
						rank_list.set(i, rank_list.get(i) - 1);
						rank_list.set(j, rank_list.get(j) - 1);
				}
			}
		}

		for(int i=0; i<N; i++) {
			System.out.print(rank_list.get(i) + " ");
		}	

	}
}