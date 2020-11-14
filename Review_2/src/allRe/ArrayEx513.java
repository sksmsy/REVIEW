package allRe;

public class ArrayEx513 {

	public static void main(String[] args) {
		
		int arr[] = {1,1,1,2,1};
		
		int cnt = 0;
		int temp[] = arr;
		arr = new int [5];
		
		
		for (int i = 0; i < temp.length; i++) {
			arr[cnt] = temp[i];
			int check = 0;
			for (int j = 0; j < temp.length; j++) {
				if(j != i && arr[cnt] == temp[j]) {
					check = 1;
				}
			}
			
			if(check == 1) {
				cnt++;
			}
		}
		
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i] + " ");
		}
			

	}

}
