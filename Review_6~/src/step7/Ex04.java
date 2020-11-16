package step7;

import java.util.Scanner;

class Seat{
	boolean check;
	void showData() {
		if(check == true) {
			System.out.print("X ");
		}
		else {
			System.out.print("O ");
		}
	}
}



public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		
		Seat [] seatList = new Seat[8];
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat();
		}
		
		while(true) {
			for (int i = 0; i < seatList.length; i++) {
				seatList[i].showData();
			}
			System.out.println();
			
			System.out.print("[1~8] >>>");
			int sel = sc.nextInt()-1;
			
			if(seatList[sel].check == false) {
				seatList[sel].check = true;
			}
			
			
		}
		
	}

}
