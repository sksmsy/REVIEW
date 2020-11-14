package step4_17;

public class StringEx09 {

	public static void main(String[] args) {


		//이름과 성적을 하나의 문자열로 연결
		
		String name[] = {"가나다","라마바","사아자"};
		int scr[] = {87, 42, 95};
		
		String str = "";
		
		for (int i = 0; i < scr.length; i++) {
			str += name[i];
			str += "/";
			str += String.valueOf(scr[i]);
			if(i != scr.length-1){
				str += ",";
			}
		}
		System.out.println(str);
	}

}
