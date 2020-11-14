package step6_1;

class Calculation{
	
	double num1;
	double num2;
	double result;
	
	// 메서드는 전부 독립공간 
	// -> double a, double b 는 네번이나 사용하지만 각각 다른 변수
	
	void plus(double a, double b) {
		result = a + b;
	}
	void minus(double a, double b) {
		result = a - b;
	}
	void multiply(double a, double b) {
		result = a * b;
	}
	void division(double a, double b) {
		result = a / b;
	}
	
	void print_result() {
		System.out.println(result);
	}
	
}
public class Ex04 {
	public static void main(String[] args) {
		
		Calculation cal = new Calculation();
		
		double a = 10;
		double b = 20;
		
		cal.plus(a, b);
		cal.print_result();

		cal.minus(a, b);
		cal.print_result();
		
		cal.multiply(a, b);
		cal.print_result();
		
		cal.division(a, b);
		cal.print_result();
	}
}
