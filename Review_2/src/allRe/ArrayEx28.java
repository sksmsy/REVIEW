package allRe;

import java.util.Random;

public class ArrayEx28 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		int arr[] = new int [5];
		
		for (int i = 0; i < arr.length; i++) {
			int r = ran.nextInt(10)+1;
			arr[i] = r;
			
			for (int j = 0; j < arr.length; j++) {
				if(i != j && arr[j] == arr[i]) {
					i -= 1;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
	}

}
