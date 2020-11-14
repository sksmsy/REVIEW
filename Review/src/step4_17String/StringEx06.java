package step4_17String;

public class StringEx06 {

	public static void main(String[] args) {
		
		String a = "890101-2012932";
		
		//ex1) 나이
		
		String age = a.substring(0,2);
		int iAge = Integer.parseInt(age);
		System.out.println(2020-(1900+iAge)+"살");
		
		//ex2) 성별
		char j =  a.charAt(7);
		if(j == '1' || j== '3') {
			System.out.println("남");
		}else if(j == '2' || j == '4') {
			System.out.println("여");
		}
	}

}
