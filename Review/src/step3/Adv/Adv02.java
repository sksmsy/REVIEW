package step3.Adv;

import java.util.Random;

public class Adv02 {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int arr[] = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			int r = ran.nextInt(5)+1;
			arr[i] = r;
			
			int cnt = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					cnt+= 1;
					if(cnt > 2) {
						i -= 1;
					}
				}
			}
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

}
