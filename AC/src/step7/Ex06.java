package step7;

import java.util.Random;

class Lotto{
	int data[] = new int[8];
	boolean win = false;
	void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
}

public class Ex06 {

	public static void main(String[] args) {

		Random ran = new Random();
		Lotto[] lotto = new Lotto[5];
		boolean check = false;
		
		int n = 0;
		while(n < 5) {
			lotto[n] = new Lotto();
			for (int i = 0; i < 8; i++) {
				int r = ran.nextInt(2);
				if(r == 0) {
					lotto[n].data[i] = 0;
				}else {
					lotto[n].data[i] = 3;
				}
			}
			
			
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				if(lotto[n].data[i] == 3) {
					cnt += 1;
					if(cnt == 3) {
						lotto[n].win = true;
						break;
					}
				}else {
					cnt= 0;
				}
			}
			if(check == false && lotto[n].win == true) {
				check = true;
				n+= 1;
			}else if(check == true && lotto[n].win == false) {
				n += 1;
			}
		}
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(5);
			Lotto temp = lotto[0];
			lotto[0] = lotto[r];
			lotto[r] = temp;
		}
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i].print();
		}
		
	}

}
