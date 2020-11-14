package step6_3_method2;

class TestReturn4{
	
	int cntMultiple4(int arr[]) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 4 == 0) {
				cnt += 1;
			}
		}
		return cnt;
	}
	
	
	int [] cntMultipleArray(int arr[]) {
		int cnt = cntMultiple4(arr);
		int temp [] = new int[cnt];
		
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 4 == 0) {
				temp[j] = arr[i];
				j+= 1;
			}
		}
		return temp;
	}
	
	void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}


public class Ex21 {

	public static void main(String[] args) {

		TestReturn4 t4 = new TestReturn4();
		
		int arr[] = {87, 12, 21, 56,100};
		
		//ex1) 4의 배수의 개수를 리턴해주는 메서드
		
		int cnt = t4.cntMultiple4(arr);
		System.out.println("cnt = " + cnt );
		
		
		//ex2) 4의 배수만 배열 타입으로 리턴해주는 메서드
		
		int temp[] = t4.cntMultipleArray(arr);
		t4.print(temp);
		
		
	}

}
