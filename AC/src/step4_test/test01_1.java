package step4_test;

public class test01_1 {

	public static void main(String[] args) {

		String [][] student = {
				{"aaa","신촌","1001"}, 
				{"bbb","강남","1002"},
				{"ccc","대치","1003"},
				{"ddd","강동","1004"}
		};
		String[][] scr = {
				{"1001" ,"100","20", "30"},
				{"1002" ,"10" ,"60", "60"},
				{"1003" ,"23" ,"63", "31"},
				{"1004" ,"45" ,"30", "35"},
		};
		
		//전체 성적이 1등인 학생 이름 출력
		int top = 0;
		int idx = 0;
		for (int i = 0; i < scr.length; i++) {
			int tot = 0;
			for (int j = 1; j < scr.length; j++) {
				tot += Integer.parseInt(scr[i][j]);
			}
			if(tot > top) {
				top = tot;
				idx = i;
			}
		}System.out.println("최고점 : " + student[idx][0]+ ","+ top);
		
		
	}

}
