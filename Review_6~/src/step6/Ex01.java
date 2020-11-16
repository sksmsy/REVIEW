package step6;

class Ex1{
	int x ;
	int y;
}

public class Ex01 {

	public static void main(String[] args) {
		/*
		 *  # Class
		 *  
		 *  1.정의
		 * 	 1)class : 키워드
		 *   2)Ex1   : 클래스 명
		 *   3){}	 : 자료의 영역 (기본 자료형을 조합해 생성
		 *  2.선언
		 *   1)자료형  변수명 = new 자료형();
		 *   2)Ex1 e = new Ex1();
		 */
		
		
		Ex1 e = new Ex1();
		e.x = 10;
		e.y = 20;
		
		System.out.println(e);  //주소 출력 -> 클래스도 주소변수
		System.out.println(e.x);
		System.out.println(e.y);
		
		//아래 배열과 비슷한 느낌
		int arr[] = new int[3];
		System.out.println(arr);
	}
}
