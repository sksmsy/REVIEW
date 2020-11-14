package step4_17;

public class StringEx07 {

	public static void main(String[] args) {

		String str = "11/100/89";
		
		//ex1) arr배열에 각 점수를 저장하고 총점 출력
		String temp [] = str.split("/");
		
		int arr[] = new int[3];
		int tot = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			tot += arr[i];
		}System.out.println(tot);
		
		//ex2) scr 배열의 각 점수를 슬러시 구분자로 하나의 문자열로 연결
		
		int scr [] = {11, 100, 89};
		
		String text ="";
		
		for (int i = 0; i < scr.length; i++) {
			text += arr[i];
			if(i != scr.length-1) {
				text+="/";
			}
		}System.out.println(text);
		
	}

}
