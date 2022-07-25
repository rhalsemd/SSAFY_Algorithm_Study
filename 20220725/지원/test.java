public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		//int [] intArr= {1,2,3}; //에러
		Integer [] intArr= {1,2,3};
		Arrays.sort(intArr,Collections.reverseOrder());
		
		//char [] charArr= {'1','2','3'}; //에러
		Character [] charArr= {'1','2','3'};
		Arrays.sort(charArr,Collections.reverseOrder());
		
		
		
		String [] stringArr= {"1","2","3"};
		Arrays.sort(stringArr,Collections.reverseOrder());
		
		 
		
	}

}
