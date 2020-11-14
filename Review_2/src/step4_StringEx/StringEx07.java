package step4_StringEx;

public class StringEx07 {

	public static void main(String[] args) {
		
		
		String str= "11/100/89";
		//ex1) arr배열에 각 점수를 저장하고 총점 출력
		
		String ar[] = str.split("/");
		int arr[] = new int[3];
		int tot = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(ar[i]);
			tot += arr[i];
		}System.out.println(tot);
		
		
		//ex2) scr배열의 각 점수를 슬러시로 구분하고 하나의 문자열로 연결
		int scr[] = {11, 100, 89};
		String text = "";
		
		for (int i = 0; i < scr.length; i++) {
			text += String.valueOf(arr[i]);
			
			if(i != scr.length-1) {
				text += "/";
			}
		}System.out.println(text);
		
	}

}
