package step6_3_method2;

import java.util.Scanner;

class Shop{
	Scanner sc = new Scanner(System.in);
	
	String name = "";
	int arPrice [] = { 2500, 3800, 1500, 1000};
	String menu[] = {"aaa", "bbb","ccc","ddd"};
	int arCnt[] = new int[4];
	int tot = 0;
	
	void show() {
		System.out.println("=====" + name +"=====");
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i+1) +"." + menu[i] + " : " + arPrice[i]);
		}
		System.out.println("5.종료");
	}
	
	void select1() { arCnt[0] += 1; }
	void select2() { arCnt[1] += 1; }
	void select3() { arCnt[2] += 1; }
	void select4() { arCnt[3] += 1; }

	void getRe() {
		System.out.println("===== 영수증 =====");
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i+1)+"." + menu[i] + " : " + arCnt[i] );
			tot = arPrice[i] * arCnt[i];
		}
		System.out.println("total : " + tot);
		
	}

	void run() {
		while (true) {
			
			show();
			
			System.out.print("메뉴선택 : ");
			int choice = sc.nextInt();
			
			if(choice == 1) { select1(); }
			
			else if(choice == 2) {select2();}
			else if(choice == 3) {select2();}
			else if(choice == 4) {select2();}
			else if(choice == 5) {
				getRe();
				break;
			}
		}
	}


}

public class Ex24 {

	public static void main(String[] args) {
		Shop sh = new Shop();
		sh.name = "abcd";
		
		sh.run();
		
	}

}
