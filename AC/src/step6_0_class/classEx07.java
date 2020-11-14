package step6_0_class;

import java.util.Scanner;

class Ex07{
	int seat[] = new int[7];
	int money = 0;
}


public class classEx07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Ex07 e = new Ex07();
		
		while(true) {
			
			System.out.println("[1]예매");
			System.out.println("[2]종료");
			
			int sel = sc.nextInt();
			
			if(sel == 1) {
			
				for (int i = 0; i < e.seat.length; i++) {
					System.out.print(e.seat[i] + " ");
				}
				System.out.println();
				System.out.print("좌석 선택 : ");
				int idx = sc.nextInt();
				
				if(e.seat[idx-1] == 0) {
					e.seat[idx-1] = 1;
					System.out.println("예매 완료");
					e.money += 12000;
					
				}else if(e.seat[idx] == 1) {
					System.out.println("이미 예매된 좌석입니다.");
				}
				
				
				
				
			}
			else if(sel == 2) {
				System.out.println(e.money);
				break;
			}
		}
		
	}

}
