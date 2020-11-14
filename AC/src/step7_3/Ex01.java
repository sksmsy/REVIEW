package step7_3;

class ConstructorTest{
	int a;
	int b;
	int c;
	ConstructorTest(){
		a = 10; b = 10; c = 10;
		System.out.println("생성자");
	}
}

public class Ex01 {

	public static void main(String[] args) {
		
		/*
		 * #Constructor
		 * 
		 * 1. 생성자는 반드시 클래스 이름과 같아야함
		 * 2. 생성자는 new 클래스명(); 이때 호출된다.
		 * 3. 생성자는 멤버변수를 초기화 시킬 목적으로 사용한다.
		 * 4. 생성자를 정의하지 않으면, 자바 컴파일러가 자동으로 기본 생성자를 만든다.
		 * 5. 기본생성자란 매개변수에 아무것도 없는 생성자를 의미한다.
		 * 6. 생성자를 정의하면 기본 생성자는 자동으로 만들어지지 않는다.
		 * 7. 생성자는 리턴타입을 가지지 않고 return도 사용하지 않는다. (메서드와 차이)
		 * 
		 */
		
		ConstructorTest test = new ConstructorTest(); // 이때 기본 생성자가 실행.
		//생성자는 기본값 저장하고싶을때 사용한다.
		
	}

}
