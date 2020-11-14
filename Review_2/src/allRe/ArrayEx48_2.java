package allRe;

public class ArrayEx48_2 {

	public static void main(String[] args) {
		
		int jangCnt = 5;
		
		String[][] jang = {
			{"철수", "김밥"},
			{"영희", "감"},
			{"철수", "사과"},
			{"영희", "사과"},
			{"영희", "김밥"}
		};
		
		
	

		for (int i = 0; i < jang.length; i++) {
			String max = jang[i][0];
			int maxIdx = i;
			for (int j = i; j < jang.length; j++) {
				if(max.compareTo(jang[j][0])> 0 ) {
					max = jang[j][0];
					maxIdx = j;
				}
			}
			
			
			String temp[] = jang[i];
			jang[i] = jang[maxIdx];
			jang[maxIdx] = temp;
		}
		
		
		for (int i = 0; i < jang.length; i++) {
			String max = jang[i][1];
			int maxIdx = i;
			
			for (int j = i; j < jang.length; j++) {
				if(jang[i][0].compareTo(jang[j][0])==0) {
					if(max.compareTo(jang[j][1])>0) {
						max = jang[j][1];
						maxIdx = j;
					}
				}
			}
			
			String temp[] = jang[i];
			jang[i] = jang[maxIdx];
			jang[maxIdx] = temp;
			
		}
		
		for(int i=0; i<jang.length; i++) {
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}



	}

}
