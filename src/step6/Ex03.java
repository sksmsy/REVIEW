package step6;

class Ex3{
	int [] arr = {87, 100, 11, 72, 92};
}
public class Ex03 {
	public static void main(String[] args) {
	
		Ex3 e = new Ex3();
		//ex1)전체 합 출력
		
		int tot = 0;
		for (int i = 0; i < e.arr.length; i++) {
			tot += e.arr[i];
		}
		System.out.println(tot);
		
		//ex2) 4의 배수 합
		
		tot = 0;
		for (int i = 0; i < e.arr.length; i++) {
			if(e.arr[i] % 4 == 0) {
				tot += e.arr[i];
			}
		}
		System.out.println(tot);
		
		
		//ex3) 4의 배수의 개수
		int cnt = 0;
		for (int i = 0; i < e.arr.length; i++) {
			if(e.arr[i] % 4 == 0) {
				cnt ++;
			}
		}
		System.out.println(cnt);
		
		//ex4) 짝수의 개수
		cnt = 0;
		for (int i = 0; i < e.arr.length; i++) {
			if(e.arr[i] % 2 == 0) {
				cnt ++;
			}
		}
		
		System.out.println(cnt);
	}
	
}
