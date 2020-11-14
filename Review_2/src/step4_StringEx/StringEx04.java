package step4_StringEx;

public class StringEx04 {

	public static void main(String[] args) {
		
		
		
		String str = "abcdef";
		System.out.println(str);
		
		
		//[1] 문자열의 길이
		int size = str.length();
		System.out.println(size);
		
		//[1] 문자 한개 추출 ( 인덱싱 ) 
		
		char ch = str.charAt(0);
		System.out.println(ch);
		ch = str.charAt(size-1);
		System.out.println(ch);
		
		
		//[2] 문자 여러개 추출(슬라이싱)
		
		String rs = str.substring(0,1);
		System.out.println(rs);
		
		rs = str.substring(0);
		System.out.println(rs);
		
		//[3] 구분자로 잘라내기
		
		str = "hello/java/wolrd";
		String arr[] = str.split("/");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
