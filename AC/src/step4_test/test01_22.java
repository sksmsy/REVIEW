package step4_test;

public class test01_22 {

	public static void main(String[] args) {
		
		String [][] student = {
				{"aaa","신촌","1001"}, 
				{"bbb","강남","1002" },
				{"ccc" ,"대치", "1003"},
				{"ddd" , "강동","1004"}
		};
		String[][] score = {
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
		
		int arr[][] = new int[score.length][2];
		for (int i = 1; i < arr.length; i++) {
			arr[i][0] = Integer.parseInt(score[i][0]);
			arr[i][1] = Integer.parseInt(score[i][2]);
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			int max = 0;
			int maxIdx = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][0] == arr[j][0]) {
					max += arr[j][1];
				}	
			}
			
		}
		

	}

}
