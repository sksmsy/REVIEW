package step6_1_method1;
//매서드 기본구조 
//정의
//1) void 				==> 키워드
//2) setNums 			==> 이름
//3) (int a , int b )   ==> main에서 보내진값들을 저장하는변수(매개변수)
//4) {기능}             ==> 실행되는 영역 
	
//사용법
//test1.setNums(10, 20);
//1) test1     ==> 클래스변수명
//2) .setNums  ==> .함수이름
//3) (10, 20); ==> (전달할값);

class Test3{
	int num1;
	int num2;
	
	void setNum(int a, int b) {
		num1 = a;
		num2 = b;
		
	}
	void printNum() {
		System.out.println(num1 + " " + num2);
	}
	
}
public class Ex03 {
	public static void main(String[] args) {
		Test3 t =  new Test3();
//		t.num1 = 10;
//		t.num2 = 20;
//		
//		System.out.println(t.num1 + " " + t.num2);
		
		t.setNum(10, 20);
		t.printNum();
		
	}
}
