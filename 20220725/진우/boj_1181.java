import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] arr = new String[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.next();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);  // 오름차순 정렬
				}
				else {
					return s1.length() - s2.length();  // 길이 순으로 정렬 
				}
			}
		});
		
		// 현재 값과 다음값을 비교하지 말고 
//		for(int i=0; i<n; i++) {
//			if(arr[i].equals(arr[i+1])) {
//				System.out.println(arr[i]);
//				i++;
//			}
//			else {
//				System.out.println(arr[i]);
//			}
//		}
		
		// 맨 처음 값 초기 출력 후 현재 값과 이전 값을 비교하도록 하면 인덱스 문제를 쉽게 처리가능 
		System.out.println(arr[0]);
		
		for(int i=1; i<n; i++) {
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}
		
	}

}
