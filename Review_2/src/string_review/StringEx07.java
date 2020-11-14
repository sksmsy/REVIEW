package string_review;

public class StringEx07 {

	public static void main(String[] args) {
		
		String str = "11/100/89";
		// arr에 배열에 각 점수를 저장, 총점출력
		
		String temp[] = str.split("/");
		
		int arr[] = new int [3];
		int tot = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			tot += arr[i];
		}System.out.println(tot);
		
		//scr배열 각 점수를 슬러시를 구분자로 하나의 문자열로 연결
		
		int scr [] = {11, 100, 89};
		String text= "";
		
		for (int i = 0; i < scr.length; i++) {
			text += String.valueOf(scr[i]);
			
			if(i != scr.length-1) {
				text+="/";
			}
		}System.out.println(text);
	}

}
