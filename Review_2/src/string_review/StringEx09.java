package string_review;

public class StringEx09 {

	public static void main(String[] args) {
		
		String name[] = {"가나다", "라마바", "사아자"};
		int scr [] = {87,42,95};
		
		String str= "";
		
		for (int i = 0; i < scr.length; i++) {
			
			str += name[i];
			str += "/";
			str += String.valueOf(scr[i]);
			if(i != scr.length-1) {
				str += ",";
			}
		}
	
		System.out.println(str);
	}
}
