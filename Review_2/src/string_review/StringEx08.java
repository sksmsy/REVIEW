package string_review;

public class StringEx08 {

	public static void main(String[] args) {
		
		String str = "가나다/87,라마바/42,사아자/95";
		
		String name[] = new String[3];
		int scr[] = new int[3];
		
		String temp[] = str.split(",");
		
		for (int i = 0; i < temp.length; i++) {
			String info []= temp[i].split("/");
			
			name[i] = info[0];
			scr[i] = Integer.parseInt(info[1]);
		}
		
		for (int i = 0; i < temp.length; i++) {
			System.out.println(name[i] +" : " + scr[i]);
		}
	}

}
