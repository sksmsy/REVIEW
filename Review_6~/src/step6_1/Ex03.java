package step6_1;

/*
 * # 메서드의 기본구조
 * 
 * 정의
 * 1)void  -> 키워드
 * 2)setNum - > 이름
 * 3)(int a , int b ) -> main 에서 보내진 값들을 저장하는 변수 (매개변수)
 * 4){기능} - > 실행영역
 * 
 * 사용법
 * test.setNum(10, 20);
 * 1)test  -> 클래스 변수 명
 * 2).setNum - >함수 이름
 * 3)(10, 20) -> 전달 할 값
 * 
 */

class Ex3{
	int num1;
	int num2;
	
	void setNum(int a , int b) {
		num1 = a;
		num2 = b;
	}
	void printNum() {
		System.out.println(num1 + ", " + num2);
	}
}
public class Ex03 {
	public static void main(String[] args) {
	
		Ex3 e = new Ex3();
		
		e.setNum(10, 20);
		e.printNum();
		
	}
}
