package step6_1_method1;

class Data{
	int result;
}
class Calc{
	void plus(Data data, int a, int b) {
		data.result = a + b;
	}
	void minus(Data data, int a, int b) {
		data.result = a - b;
	}
}


public class Ex07 {

	public static void main(String[] args) {

		Data d = new Data();
		Calc c = new Calc();
		
		c.plus(d, 10, 3);
		System.out.println(d.result);
		c.minus(d, 10, 3);
		System.out.println(d.result);
		
	}

}
