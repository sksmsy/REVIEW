package step6_1_method1;

class Test5{
	void setValue(int a) {
		
		a = 100;
	}
}
public class Ex05 {

	public static void main(String[] args) {
		int a = 56;
		Test5 t = new Test5();
		
		//메서드는 값을 복사하는것이기 때문에 main안의 a에 영향이 없다.
		t.setValue(a);
		System.out.println(a);
		
		System.out.println("------------------------");
		
		//아래와 같은 동작
		
		int b = 20;
		int c = b;
		c = 100;
		
		System.out.println(b);
		
	}

}
