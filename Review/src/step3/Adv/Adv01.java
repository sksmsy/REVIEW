package step3.Adv;

public class Adv01 {

	public static void main(String[] args) {
		
		int k = 0;
		int n = 1;
		for(int i=0; i<9; i++) {
			for(int j=8; j>i; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print(n+" ");
			}
			System.out.println();
			n+=1;
			
		}
		



	}

}
