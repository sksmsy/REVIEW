package string_review;

public class StringEx04 {

	public static void main(String[] args) {
		
		//012345
		String str = "ABCDEF";
		System.out.println(str);
		
		
		// [1] 길이 
		int size = str.length();
		System.out.println(size);
		
		//[1] 인덱싱
		char ch = str.charAt(1);
		System.out.println(ch);
		ch = str.charAt(size-2);
		System.out.println(ch);
		
		
		//[2] 슬라이싱
		String sl = str.substring(2,4);
		System.out.println(sl);
		
		sl = str.substring(3);
		System.out.println(sl);
		
		
		//[3]구분자 split
		str = "hello/java/world";
		String arr[] = str.split("/");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
