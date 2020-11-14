package step3;


public class StringEx03 {

	public static void main(String[] args) {
		
		String a[] = {"홍", "김", "마", "자", "서"};
		
		for (int i = 0; i < a.length; i++) {
			String maxStr = a[i];
			int maxIdx = i;
			for (int j = i; j < a.length; j++) {
				if(maxStr.compareTo(a[j])> 0) {
					maxStr = a[j];
					maxIdx = j;
				}
			}
			String temp = a[i];
			a[i] = a[maxIdx];
			a[maxIdx] = temp;
			
		}

		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
