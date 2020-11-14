package step4_17;

public class StringEx05 {

	public static void main(String[] args) {
		
		//char ->int
		char ch = 'a';
		int aNum = (int)ch;
		System.out.println(aNum);
		
		ch = (char)(aNum+1);
		System.out.println(ch);
		
		//string ->int
		String strNum = "10";
		int num = Integer.parseInt(strNum);
		System.out.println(num);
		
		//int ->String
		strNum = String.valueOf(num);
		System.out.println(strNum+1);
		

	}

}
