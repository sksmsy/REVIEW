package step6_1_method1;

import java.util.Scanner;

class Member{
	// 클래스  
	// 1) 변수
	// 2) 메서드
	
	String name = "";
	int num;
	int age;
	int gender; // 1 남, 2 여
	
	// 메서드(함수)
	// . equals(), print(), substring(), charAt(), ...
	// . 이미 구현한 코드를 재사용(재활용)기 위함
	
	// 정의
	// 리턴할자료형 함수명(){ 재활용할실행문; }
	// void : 정해지지 않은 자료형
	// int, String, char, double ...
	void sayHello() {
		System.out.println("안녕!");
	}
	
	// 함수 유형 4가지
	void func1() {
		System.out.println("10");
//		return;
	}
	void func2(String n) { // Parameter 매개변수 
		System.out.printf("%s야 안녕!\n", n);
//		return;
	}
	
	int func3() {
		int result = 100;
		return result;
	}
	int func4(int a, int b, String c) {
		int result = a + b;
		System.out.println("c : " + c);
		return result;
	}
	
}


public class Ex00 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		int data = sc.nextInt(); // integer 값을 리턴하는 함수 
//		System.out.println(data);
		
		Member mb = new Member();
		mb.sayHello();
		
//		System.out.print();
		mb.func2("윤혁이"); // argument 전달인자 
		
		int num = mb.func3();
		System.out.println("num : " + num);
		
		int num1 = 10;
		int num2 = 20;
		String s = "dooly";
		System.out.println(mb.func4(num1, num2, s));
		
		
	}

}
