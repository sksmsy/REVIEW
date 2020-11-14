package step4_test;

public class test01_3_1 {

	public static void main(String[] args) {
		String nameData = "";
		nameData+=	"100001/이만수";nameData += "\n";		
		nameData += "100002/이영희";nameData += "\n";
		nameData += "100003/유재석";nameData += "\n";
		nameData += "100004/박명수";nameData += "\n";
		nameData += "100005/최여정";nameData += "\n";
		nameData += "100006/박병욱";
		
		String  moneyData = "";
		moneyData += "100001/600";moneyData += "\n";	
		moneyData += "100003/7000";moneyData += "\n";		
		moneyData += "100001/100";moneyData += "\n";		
		moneyData += "100002/400";moneyData += "\n";		
		moneyData += "100001/600";moneyData += "\n";		
		moneyData += "100004/900";moneyData += "\n";		
		moneyData += "100001/130";moneyData += "\n";		
		moneyData += "100003/200";moneyData += "\n";		
		moneyData += "100002/700";moneyData += "\n";	
		moneyData += "100002/900";moneyData += "\n";
		moneyData += "100004/800";
		
		// 문제) moneyData 와 nameData 를 조합해서 아래와같이 만들어보세요
		String userData = "";
		/*
		 * 100001/이만수/600
		 * 100003/유재석/7000
			...
		 */
		
		String name [] = nameData.split("\n");
		String money[] = moneyData.split("\n");
		String money2 [][] = new String[moneyData.length()][2];
		
		for (int i = 0; i < money.length; i++) {
			String temp [] = money[i].split("/");
			
			money2[i][0] = temp[0];
			money2[i][1] = temp[1];
			
		}
		
		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < money2.length; j++) {
				if(name[i].substring(0,6).equals(money2[j][0])) {
					userData += name[i]+"/"+money2[j][1];
					userData +="\n";
				}
			}
		}
		System.out.println(userData);
		

	}

}
