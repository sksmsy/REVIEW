package step4_17;

public class StringEx08 {

	public static void main(String[] args) {
		
		//이름은 name 배열 성적은 scr 배열에 각각 저장 및 출력
		
		String str = "가나다/87,라마바/42,사아자/95";
		
		String name [] = new String[3];
		int scr [] = new int[3];
		
		
		String temp[] = str.split(",");
		
		for (int i = 0; i < scr.length; i++) {
			String temp2[] = temp[i].split("/");
			
			name[i] = temp2[0];
			scr[i] = Integer.parseInt(temp2[1]);
			
		}
		
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " : " + scr[i]);
		}
		
	}

}
