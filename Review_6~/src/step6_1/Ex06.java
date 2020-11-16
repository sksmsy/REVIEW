package step6_1;

class Ex6{
	void change(int [] arr) {
		arr[1] = 100;
	}
}
public class Ex06 {

	public static void main(String[] args) {
		
		int arr[] = {10,20,30,40,50};
		Ex6 e6 = new Ex6();
		
		//배열은 주소이기때문에 바뀜
		e6.change(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println("=========================");
		
		//아래와 같은 구조
		int testArr[] = {10,20,30,40};
		int temp[] = testArr;
		temp[1] = 100;
		for (int i = 0; i < testArr.length; i++) {
			System.out.println(testArr[i] + " ");
		}
		
	}
	
}
