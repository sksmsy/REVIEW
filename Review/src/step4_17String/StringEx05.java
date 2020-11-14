package step4_17String;

public class StringEx05 {

	public static void main(String[] args) {
		
		
		//char - > int
		char ch = 'a';
		int aNum = (int)ch;
		System.out.println(aNum);
		
		ch = (char)(aNum+1);
		System.out.println(ch);
		
		
		//String -> int
		String strNum = "10";
		int num = Integer.parseInt(strNum);
		System.out.println(num + 1);
		
		//int -> String
		strNum = num+"";
		System.out.println(strNum+1);
		
		strNum = String.valueOf(num);
		System.out.println(strNum+1);
	}

}
