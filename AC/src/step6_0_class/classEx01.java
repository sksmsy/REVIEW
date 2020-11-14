package step6_0_class;


class Ex01{
	int x;
	int y;
}



public class classEx01 {

	/*
	 *  # 클래스
	 *  1.정의 (설계도)
	 *   1) class  : 키워드
	 *   2) Ex01   : 클래스명
	 *   3){}	   : 자료형의 영역(기본 자료형을 조합해 생성)
	 *  2.선언 
	 *   1) 자료형 변수명  = new 자료형();
	 *   2) Ex01 e = new Ex01();
	 *  
	 */
	
	
	public static void main(String[] args) {
		
		Ex01 e = new Ex01(); // 클래스 : 사용자 정의 자료형
		e.x = 10;
		e.y = 20;
		
		System.out.println(e); //클래스도 주소변수
		System.out.println(e.x);
		System.out.println(e.y);
		//배열과 같은느낌으로 사용하면 된다.
		
		//-----------------------------------------------------
		
		int arr[] = new int[3];
		System.out.println(arr);
		
	}

}
