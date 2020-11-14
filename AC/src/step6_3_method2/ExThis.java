package step6_3_method2;

class thisTest{
	int a;
	String name;
	int scr;
	
	void test() {
		int a = 10;
		
		this.a = 100;
		System.out.println("------------------");
		System.out.println(a);
		System.out.println(this.a);
		System.out.println("------------------");
		
		this.name = "aaa";
		this.scr  = 100;
	}
}

public class ExThis {

	public static void main(String[] args) {

		thisTest tt = new thisTest();
		tt.test();
		System.out.println(tt.a);
	}

}
