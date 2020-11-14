package step6_1_method1;

import java.util.Scanner;

class Cal{
	
	double num1;
	double num2;
	double result;
	
	
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
	
	void print() {
		System.out.println(result);
	}
	
}

public class Ex04 {

	public static void main(String[] args) {
		Cal c = new Cal();
	
		double a = 10;
		double b = 3;
		c.plus(a, b);
		c.print();
		
		c.minus(a, b);
		c.print();
		
		c.multiply(a, b);
		c.print();
		
		c.division(a, b);
		c.print();
		
	}

}
