package step4_18;

public class ExceptionEx01 {

	public static void main(String[] args) {

		int num = 10;
		
		try {
			System.out.println(num / 0);
		}catch(Exception e) {
			System.out.println("0으로 나눌수 없음");
		}
		
		
		System.out.println("종료");
	}

}
