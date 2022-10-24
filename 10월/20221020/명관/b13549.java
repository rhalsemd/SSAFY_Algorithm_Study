package study20221020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b13549 {

	static int N;
    static int K;
    static int[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        visited = new boolean[100001];
        System.out.println(search());
    }

    static int search() {

        if (N == K) // 시작위치가 목적지면 0반환
            return 0;

        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(new Location(N, 0));
        visited[N] = true;

        while (!pq.isEmpty()) {
            Location current = pq.poll(); 
            visited[current.x] = true; // 이 때 방문체크를 해야 순서 의존도가 생기지않음. 

            if (isFinalLocation((current.x))) {
                return current.value;
            }

            if (current.x * 2 < 100001 && !visited[current.x * 2]) {
                pq.add(new Location(current.x * 2, current.value));
            }

            if (current.x - 1 >= 0 && !visited[current.x - 1]) {
                pq.add(new Location(current.x - 1, current.value + 1));
            }
            if (current.x + 1 < 100001 && !visited[current.x + 1]) {
                pq.add(new Location(current.x + 1, current.value + 1));
            }
        }
        return -1;
    }

    static boolean isFinalLocation(int x) {
        if (x == K) {
            return true;
        }
        return false;
    }

    static class Location implements Comparable<Location>{
        int x;
        int value;

        public Location(int x, int value) {
            this.x = x;
            this.value = value;
        }

        @Override
        public int compareTo(Location o) {
            return this.value - o.value;
        }
    }

}
