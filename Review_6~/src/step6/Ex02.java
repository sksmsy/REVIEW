package step6;

class Ex2{
	String name;
	int scr;
}

public class Ex02 {
	public static void main(String[] args) {

		
		Ex2 e = new Ex2();
		
		e.name = "sksmsy";
		e.scr = 100;
		
		System.out.println(e.name + " : "+e.scr);
		
		//같은 패키지 안의 클래스는 다른 클래스에서 사용 가능
		Ex1 e1 = new Ex1();
		e1.x = 10;
		e1.y = 20;
		
		System.out.println(e1.x + "," + e1.y);
		
	}
}
