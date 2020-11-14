package step3.Adv;

public class Adv1_1 {

	public static void main(String[] args) {
	
		int rowcnt =1;
		for (int i = 9; i >=1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 1; k <= rowcnt ; k++) {
				System.out.print(rowcnt+" ");
			}
			System.out.println();
			rowcnt ++;
		}
		
	}

}
