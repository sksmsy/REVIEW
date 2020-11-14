package step4_17;

public class StringEx06 {

	public static void main(String[] args) {
		
		String num = "891010 - 2012932";
		
		// 나이
		 
		int age = Integer.parseInt(num.substring(0,2));
		System.out.println(2020 - (1900 + age ) + "세");
		
		//성ㅇ별
		
		char j = num.charAt(7);
		if(j =='1' || j=='3' ) {
			System.out.println("남");
		}else if(j=='2' || j == '4') {
			System.out.println("여");
		}
			
			

	}

}
