package step4_17;

public class StringEx04 {

	public static void main(String[] args) {
		
		String str = "abcdef";
		System.out.println(str);
		
		//[1] 길이
		int size = str.length();
		System.out.println(str);
		
		//[1] 인덱싱
		char ch = str.charAt(1);
		System.out.println(ch);
		ch = str.charAt(size-1);
		System.out.println(ch);
		
		//[2] 슬라이싱
		
		String rs = str.substring(0,3);
		System.out.println(rs);
		
		rs = str.substring(4);
		System.out.print(rs);
		
		str = "hello,java,world";
		String arr[] = str.split(",");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+ "" );
		}
	}

}
