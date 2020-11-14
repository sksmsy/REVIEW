package step6_3_method2;

import java.util.Scanner;

class myClass{
	
	// Member Variable
	int a;
	int b;
	int c;
	
	int func(int a) {
		// 내가(클래스 자신) 가지고 있는 멤버변수를 참조하는 어떠한 실행문 
		int result = this.a + this.b + this.c;
		return result;
	}
	
}

public class Ex00 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 한개를 입력 : ");
		String data = sc.next();
		
		System.out.print(1000);
		System.out.print('a');
		System.out.print("apple"); // 
		
		myClass mc = new myClass();
		
		int a = 10;
		mc.func(a);
		
		
	}

}
