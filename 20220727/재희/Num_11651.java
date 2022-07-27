import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//좌표 정렬하기2
class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Num_11651 {
	public static void main(String[] args)
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		List<Dot> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			String[] tmp = br.readLine().split(" ");
			int x = 0, y = 0;
			
			if (tmp[0].contains("-")) {				//음수일 경우 변환
				tmp[0] = tmp[0].replaceAll("-", "");
				x = Integer.parseInt(tmp[0]) * -1;
			}
			else
				x = Integer.parseInt(tmp[0]);
			
			if (tmp[1].contains("-")) {				////음수일 경우 변환
				tmp[1] = tmp[1].replaceAll("-", "");
				y = Integer.parseInt(tmp[1]) * -1;
			}
			else
				y = Integer.parseInt(tmp[1]);
			

			list.add(new Dot(x, y));
		}

		list.sort(new Comparator<Dot>() {
			@Override
			public int compare(Dot o1, Dot o2) {
				if (o1.y != o2.y)
					return o1.y - o2.y;
				else
					return o1.x - o2.x;
			}
		});

		for (int i = 0; i < list.size(); i++) {
			Dot d = list.get(i);
			bw.write(d.x + " " + d.y + "\n");
		}
		bw.flush();
		bw.close();
	}
}
