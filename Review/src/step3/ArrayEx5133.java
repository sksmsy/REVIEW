package step3;

public class ArrayEx5133 {

	public static void main(String[] args) {
		int test[] = {1,2,3,2,1};
		
		
		int cnt = 0 ;
		int temp[] = test;
		test = new int[5];
		
		
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test.length; j++) {
				if(j != i && temp[i] == temp[j]) {
					test[cnt] =temp[j];
					cnt+= 1;
				}
			}
		}
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(test[i] + " ");
			
		}
		 
		
	}

}
