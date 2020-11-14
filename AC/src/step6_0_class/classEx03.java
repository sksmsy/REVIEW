package step6_0_class;


class Ex03{
	int arr[] = { 87, 100, 11, 72, 92};
}

public class classEx03 {

	public static void main(String[] args) {

		Ex03 e = new Ex03();
		
		//ex1) 전체 합 출력
		int tot = 0;
		for (int i = 0; i < e.arr.length; i++) {
			tot += e.arr[i];
		}
		System.out.println(tot);
		
		
		//ex2) 4의 배수의 합 출력
		tot = 0 ;
		
		for (int i = 0; i < e.arr.length; i++) {
			if(e.arr[i] % 4 == 0) {
				tot+= e.arr[i];
			}
		}
		System.out.println(tot);
		
		//ex3) 4의 배수의 합 출력
		int am = 0;
		for (int i = 0; i < e.arr.length; i++) {
			if(e.arr[i] % 4 == 0) {
				am ++;
			}
		}
		System.out.println(am);
		
		
		//ex4) 짝수의 개수
		 am = 0;
		for (int i = 0; i < e.arr.length; i++) {
			if(e.arr[i] % 2 == 0) {
				am ++;
			}
		}
		System.out.println(am);

	}

}
