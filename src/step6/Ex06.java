package step6;

import java.util.Random;

class Ex6{
	int answer[] = {1,3,4,2,5};
	int hgd[] = new int[5];
	
	int cnt = 0;
	int scr= 0;
}

public class Ex06 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		
		Ex6 e = new Ex6();
		
		for (int i = 0; i < e.hgd.length; i++) {
			int r  = ran.nextInt(5)+1;
			
			e.hgd[i] = r;		
			System.out.print(e.hgd[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < e.hgd.length; i++) {
			System.out.print(e.answer[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < e.hgd.length; i++) {
			if(e.answer[i] == e.hgd[i]) {
				System.out.print("O ");
				e.cnt ++;
			}else {
				System.out.print("X ");
			}
		}
		System.out.println();
		e.scr = e.cnt * 20;
		System.out.println(e.scr);
	}
}
