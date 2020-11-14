package step4_test;

public class test01_2 {

	public static void main(String[] args) {
		String [][] student = {
				{"aaa","신촌","1001"}, 
				{"bbb","강남","1002"},
				{"ccc","대치","1003"} ,
				{"ddd","강동","1004"}
				
		};
		String[][] scr = {
				{"번호" ,"과목" , "점수"},
				{"1001" ,"국어","20"},
				{"1002" ,"국어","50"},
				{"1003" ,"국어","60"},
				{"1004" ,"국어","17"},
				{"1001" ,"수학","65"},
				{"1002" ,"수학","15"},
				{"1003" ,"수학","80"},
				{"1004" ,"수학","70"},
				{"1001" ,"영어","43"},
				{"1002" ,"영어","90"},
				{"1003" ,"영어","30"},
				{"1004" ,"영어","70"}
		};


		//전체 성적이 1등인 학생 이름 출력
		
		
		int maxTot = 0;
		int maxIdx = 0;
		for (int i = 1; i < 5; i++) {
			int tot = 0;
			for (int j = 0; j < scr.length; j++) {
				if(scr[i][0].equals(scr[j][0])) {
					tot += Integer.parseInt(scr[j][2]);
				}
				if(maxTot < tot) {
					maxTot = tot;
					maxIdx = i-1;
				}
			}
		}System.out.println("최고점수 : " + maxTot + ", 이름 : " + student[maxIdx][0] );
		
		
		
	}

}
