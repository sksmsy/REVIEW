package step3;

public class ArrayEx513 {

	public static void main(String[] args) {
		
		int test[] = {1,2,3,1,2};
		
		
		int cnt = 0;
		int temp[] = new int [5];
		
		for (int i = 0; i < 5; i++) {
			temp[cnt] = test[i];
			int check = 0;
			for (int j = 0; j < 5; j++) {
				if(i != j && temp[cnt] == test[j]) {
					check = 1;
				}
			}
			if(check == 1) {
				cnt += 1;
			}
		}
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(temp[i] +  " ");
		}
	}

}
