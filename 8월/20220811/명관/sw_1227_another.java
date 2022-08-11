package swexpert_20220811;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sw_1227_another {
	public static class Node {
        int x;
        int y;
 
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
 
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("C:\\Users\\multicampus\\Downloads\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = 10;
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                String string = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = string.charAt(j) - '0';
                }
            }
 
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(1, 1));
            arr[1][1] = 1;
            int result = 0;
            while (!queue.isEmpty()) {
                Node now = queue.poll();
                int x = now.x;
                int y = now.y;
                int d = 0;
                while (d < 4) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx > 99 || ny < 0 || ny > 99 || arr[nx][ny] == 1) {
                        d++;
                        continue;
                    }
                    if (arr[nx][ny] == 3) {
                        result = 1;
                        queue.clear();
                        break;
                    }
                    queue.offer(new Node(nx, ny));
                    arr[nx][ny] = 1;
                }
            }
            sb.append("#").append(n).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
 
}