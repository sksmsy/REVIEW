package step3;

public class ArrayEx34 {
	public static void main(String[] args) {
		
		String[] name = {"가", "나", "다", "라", "마"};
		int [] scr = {87, 42, 100, 11, 98};
		
		
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
			
			String nameTemp = name[i];
			name[i] = name[maxIdx];
			name[maxIdx] = nameTemp;
			
			
		}
		
		for (int i = 0; i < scr.length; i++) {
			System.out.println(name[i] + " : " + scr[i]);
		}
		
	}
}
