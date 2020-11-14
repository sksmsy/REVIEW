package allRe;

public class ArrayEx33 {

	public static void main(String[] args) {
		
		int scr[] = {10, 50, 30, 40, 80, 7};
		
		for (int i = 0; i < scr.length; i++) {
			int maxNum = scr[i];
			int maxIdx = i;
			
			for (int j = i; j < scr.length; j++) {
				if(maxNum < scr[j]) {
					maxNum = scr[j];
					maxIdx = j;
				}
			}
			int temp = scr[i];
			scr[i] = scr[maxIdx];
			scr[maxIdx] = temp;
			
		}
		
		for (int i = 0; i < scr.length; i++) {
			System.out.print(scr[i] + " ");
		}
		
	}

}
