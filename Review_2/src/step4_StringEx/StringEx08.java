package step4_StringEx;

public class StringEx08 {

	public static void main(String[] args) {
		
		String str = "가나다/87,라마바/42,사아자/95";
		
		String name[] = new String[3];
		int scr [] = new int[3];
		
		String temp[] = str.split(",");
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split("/");
			
			name[i] = temp2[0];
			scr[i] = Integer.parseInt(temp2[1]);
		}
		
		
		for (int i = 0; i < temp.length; i++) {
			System.out.println(name[i] + ": " + scr[i]);
		}
	}

}
