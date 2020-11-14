package step7;

import java.util.Random;

class RanNum{
	int num;
	boolean check;
}

public class Ex03 {
	public static void main(String[] args) {

		Random ran = new Random();
		
		
		RanNum[] arr = new RanNum[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new RanNum();
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			
			int r = ran.nextInt(5);
			if(arr[r].check == false) {
				arr[r].check = true;
				arr[r].num = i + 1;
			}
			else {
				i -= 1;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].num + " ");
		}
		
	}

}
