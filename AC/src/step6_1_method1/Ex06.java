package step6_1_method1;

class Test6{
	void changeValueInArray(int [] arr) {
		arr[1] = 100;
	}
}
public class Ex06 {

	public static void main(String[] args) {

		int arr[] = {10, 20, 30, 40, 50};
		Test6 t = new Test6();
		
		//배열은 주소이기때문에 바뀜.
		t.changeValueInArray(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println("------------------------");
		
		int testArr[] = {10, 20, 30,40};
		int temp[] = testArr;
		temp[1] = 100;
		for (int i = 0; i < temp.length; i++) {
			System.out.print(testArr[i] +" ");
		}
		System.out.println();
		
	}

}
