package step6_3_method2;

class TestReturn5{
	
	int result;
	int arr[];
	
	void plus(int a, int b) {
		result = a+ b;
	}
	void copyArr(int arr[]) {
		this.arr = arr;
	}
	int rePlus(int a, int b) {
		return a + b;
	}
	int[] reArr(){
		arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i+1) * 10;
		}
		return arr;
	}
	
}

public class Ex22 {

	public static void main(String[] args) {
		TestReturn5 t5 = new TestReturn5();
		
		t5.plus(10, 3);
		System.out.println(t5.result);
		
		int result = t5.rePlus(10, 3);
		System.out.println(result);
		
		System.out.println("======================");
		int arr[] = {10,20,30,40};
		t5.copyArr(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(t5.arr[i]+" ");
		}
		System.out.println();
		
		int arr2[] = t5.reArr();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
	}

}
