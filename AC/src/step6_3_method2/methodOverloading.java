package step6_3_method2;

class Mol{
	int add (int x , int y) {
		return x+ y;
	}
	int add (int x , int y , int z) {
		return x + y + z;
	}
	int add(int arr[] ) {
		int tot=0;
		for (int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		return tot;
	}
}

public class methodOverloading {

	public static void main(String[] args) {

		Mol mol = new Mol();
		
		int arr[] = {1,2,3,4,5};
		
		int r1 = mol.add(10,3);
		int r2 = mol.add(10,20,30);
		int r3 = mol.add(arr);
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		
	}

}
