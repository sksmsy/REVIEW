package step4_17String;

public class StringEx04 {

	public static void main(String[] args) {
		
		
	
		//012345
		String str = "abcdef";
		System.out.println(str);
		
		
		//[1] 문자열의 길이 length()
		int size = str.length();
		System.out.println(size);
		
		//[1] 문자 한개 추출(인덱싱)
		char ch = str.charAt(0);
		System.out.println(ch);
		ch = str.charAt(size-1);
		System.out.println(ch);
		
		//[2]문자 여러개 추출(슬라이싱)
		//1) substring(index1, index2)
		//마지막은 포함하지 않음 (index1 부터  index2 미만 까지)
		
		String rs = str.substring(0,3);
		System.out.println(rs);
		
		//2)substring(index)
		// index 부터 문자열 끝까지
		rs = str.substring(0);
		System.out.println(rs);
		
		//[3] 구분자로 잘라내기
		str= "hello,java,world";
		String[] ar = str.split(",");
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+ " ");
		}
	}

}
