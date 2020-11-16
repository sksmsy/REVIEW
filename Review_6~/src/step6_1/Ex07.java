package step6_1;

class Data{
	int result;
}

class Calc{
	void plus(Data data, int a, int b) {
		data.result = a+ b;
	}
	void minue(Data data, int a, int b) {
		data.result = a - b;
	}
}

public class Ex07 {
	public static void main(String[] args) {
		
		Data data = new Data();
		Calc cal = new Calc();
		
		//data는 new data()의 주소가 들어가 있기 때문에 가능하다.
		
		cal.plus(data, 10, 3);
		System.out.println(data.result);
		
		cal.minue(data, 100, 30);
		System.out.println(data.result);
	}
}
