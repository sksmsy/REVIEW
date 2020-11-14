package string_review;

public class StringEx05 {

	public static void main(String[] args) {
		

		//char -> int
		char ch = 'a';
		int num = (int)ch;
		System.out.println(num);
		num = (int)(ch+1);
		System.out.println(num);
		
		ch = (char)num;
		System.out.println(ch);
	
		
		//String -> int
		
		String str = "10";
		int sNum = Integer.parseInt(str);
		System.out.println(sNum+1);
		
		//int ->String 
		
		String str2 = String.valueOf(sNum);
		System.out.println(str2+1);
		
		
	}

}
