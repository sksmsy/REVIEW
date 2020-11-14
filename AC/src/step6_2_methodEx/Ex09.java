package step6_2_methodEx;

class TestEx2{
	void printSum(int[] arr) {
		int tot =0;
		for (int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		System.out.println(tot);
	}
	void printSumMulitple4(int [] arr) {
		int tot = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 4 == 0) {
				tot+= arr[i];
			}
		}
		System.out.println(tot);
	}
	void printCntMultiple4(int [] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 4 == 0) {
				cnt ++;
			}
		}
		System.out.println(cnt);
	}
	void printCntMultiple (int arr[]) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				cnt ++;
			}
		}
		System.out.println(cnt);
	}
}
public class Ex09 {

	public static void main(String[] args) {
		TestEx2 t = new TestEx2();
		
		int [] arr = {87, 100, 11, 72, 92};			
		
		//ex1)전체 합 출력
		
		t.printSum(arr);
		
		System.out.println("-----------------------");
			
		//ex2) 4의 배수의 합
		t.printSumMulitple4(arr);
		System.out.println("-----------------------");

		//ex3) 4의 배수의 개수 출력
		t.printCntMultiple4(arr);
		
		System.out.println("-----------------------");
		
		//ex4) 짝수의 개수
		t.printCntMultiple(arr);
	}

}
