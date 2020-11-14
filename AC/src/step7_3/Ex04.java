package step7_3;

class PrivateTest{
	private int a;
	public int b;
	int c;
}
//접근제어자 : public , private



public class Ex04 {
	//클래서 멤버 변수에 public이나 , private를 붙일수있다.
	
	public static void main(String[] args) {
		PrivateTest pTest =  new PrivateTest();
		//pTest.
		//private 가 붙은 변수는 클래스 내부에서만 사용가능
		// 다른 클래스에서 사용불가
		// 여기는 main -> a를 직접적으로 사용불가능
		
		//private 를 붙인 변수는 pTest. 보이지않음
		
		
		//아무것도 붙이지 않은 c는 (public)
	}

}
