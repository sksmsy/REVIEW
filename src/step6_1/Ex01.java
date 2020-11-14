package step6_1;

/*
 *  메서드의 기본 구조
 * 	
 *  - 정의
 *  1)void -> 키워드
 *  2)testPrint() -> 이름
 *  3) {기능} -> 실행되는 영역
 *  
 *  - 사용법
 *  t1.testPrint();
 *  1)t1 ->클래스 변수명
 *  2).testPrint(); -> .함수이름();
 */

class Test{
	void testPrint() {
		System.out.println(" !! ");
	}
}

public class Ex01 {

	public static void main(String[] args) {
		
		Test t1 = new Test();
		
		t1.testPrint();
		
	}
}
