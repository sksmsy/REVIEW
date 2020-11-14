package step4_test;

public class test02 {

	public static void main(String[] args) {

		int a[]= {1,1,3,3,3,100,2,2,3,1,3};
		
		
		
		int b[][] = new int[a.length][2];
		
		int bIdx = 0;
		for (int i = 0; i < b.length; i++) {
			int check = 0;
			for (int j = 0; j < a.length; j++) {
				if(a[i] == b[j][0]) {
					check = 1;
					
				}
			}
			if(check == 0) {
				b[bIdx][0] = a[i];
				bIdx ++;
			}
		}

		
		for (int i = 0; i < b.length; i++) {
			int cnt = 0;
			for (int j = 0; j < b.length; j++) {
				if(b[i][0] == a[j]) {
					cnt += 1;
				}
			}
			b[i][1] = cnt;
		}
		
		for (int i = 0; i < bIdx; i++) {
			System.out.println(b[i][0] + " : " + b[i][1]);
		}
		
	}

}
