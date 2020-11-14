package step6_2_methodEx;

import java.util.Scanner;

class MvNum {
	Scanner sc = new Scanner(System.in);
	
	int arr[] = {0,0,0,0,8,0,0,0,0,0};
	
	int player = 4;
	
	void show () {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 8) {
				System.out.print("옷 ");
			}else {
				System.out.print("0 ");
			}
		}
		System.out.println();
	}
	
	void leftMv() {
		
		if(player > 0 ) {
			arr[player] = 0;
			arr[player-1] = 8;
			player --;
		}
		
	}
	void rightMv() {

		if(player < arr.length-1) {
			arr[player] = 0;
			arr[player+1] = 8;
			player ++;
		}
	}
	
	void run() {
		while(true) {
			
			show();
			System.out.println("1.left / 2. right \n0.close");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				leftMv();
			}else if(sel == 2) {
				rightMv();
			}else {
				break;
			}
		}
	}
	
}

public class Ex13 {

	public static void main(String[] args) {

		MvNum mv = new MvNum();
		
		mv.run();
		
	}

}
