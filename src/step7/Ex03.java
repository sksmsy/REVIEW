package step7;

import java.util.Random;

class RanNum{
	int num;
	boolean check;
	
}

public class Ex03 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		
		RanNum rn[] = new RanNum[5];
		
		
		for (int i = 0; i < rn.length; i++) {
			rn[i] = new RanNum();
		}
		
		for (int i = 0; i < rn.length; i++) {
			
			int r = ran.nextInt(5);
			
			if(rn[r].check == false) {
				rn[r].check = true;
				rn[r].num = i+1;
			}else {
				i -= 1;
			}
			
		}
		
		
		
		for (int i = 0; i < rn.length; i++) {
			System.out.print(rn[i].num+ " ");
		}
		
		
	}
}
