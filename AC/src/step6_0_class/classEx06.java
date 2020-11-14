package step6_0_class;

import java.util.Random;

class Ex06{
	int answer[] = {1,2,3,4,5};
	int hgd[] = new int[5];
	
	int cnt = 0;
	int scr = 0;
}

public class classEx06 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		Ex06 e = new Ex06();
		
		for (int i = 0; i < e.hgd.length; i++) {
			System.out.print(e.answer[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < e.hgd.length; i++) {
			int r = ran.nextInt(5)+1;
			e.hgd[i] = r;
			System.out.print(e.hgd[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < e.hgd.length; i++) {
			if(e.hgd[i] == e.answer[i]) {
				e.cnt ++;
				e.scr += 20;
				System.out.print("O ");
			}else {
				System.out.print("X ");
			}
		}
		System.out.println();
		
		
		System.out.println(e.scr + "점");
		
		
	}

}
