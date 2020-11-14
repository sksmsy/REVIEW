package step7;

import java.util.Scanner;

class Seat{
	boolean check;
	void showData() {
		if(check == true) {
			System.out.print("■ ");
		}else {
			System.out.print("□ ");
		}
	}
}

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		Seat []  arr = new Seat[8];

		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Seat();
		}
		
		while(run) {
			for (int i = 0; i < arr.length; i++) {
				arr[i].showData();
			}
			System.out.println();
			System.out.print("번호입력 >>>>");
			int sel = sc.nextInt()-1;
			if(arr[sel].check == false) {
				arr[sel].check = true;
			}
		}
		
	}

}
