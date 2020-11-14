package step7;

class Product{
	String name;
	int price;
}

public class Ex01 {
	public static void main(String[] args) {

		//3칸짜리 배열이 2개 필요하면 2차원 배열 사용
		int arr[] = new int[3];
		int darr[][] = new int[2][3];
		
		//마찬가지로 클래스도 배열로 필요하면 2차원배열 처럼 만들어야함
		
		Product pr = new Product();
		pr.name = "감자깡";
		pr.price = 10000;
		
		//---------------------------------------------------------
		Product [] prList = new Product[2];
		
		for (int i = 0; i < prList.length; i++) {
			prList[i] = new Product();
		}
		
		for (int i = 0; i < prList.length; i++) {
			prList[i].price = 10+(i * 10);
		}
		
		prList[0].name = "새우깡";
		prList[1].name = "고래밥";
		
	}

}
