package step6_3_method2;

class TestReturn3{
	int num;
	void setNum(int a) {
		num = a;
	}
	
	int getNum() {
		return num;
	}
}

public class Ex20 {

	public static void main(String[] args) {
		TestReturn3 t3 = new TestReturn3();
		
		t3.setNum(10);
		int result = t3.getNum();
		System.out.println(result);
		
	}

}
