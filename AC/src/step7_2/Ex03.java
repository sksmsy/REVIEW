package step7_2;

class Member{
	int no;
	int point;
	String name;
	boolean best;
	
	
	
}

public class Ex03 {

	public static void main(String[] args) {

		String data1 = "1001/3,1002/1,1003/5,1004/1,1002/2";
		String data2 = "1001/이만수,1002/김철수,1003/신민아,1004/박상아";
		
		Member[] mbList = null;
		
		
		mbList = new Member[4];
		
		for (int i = 0; i < mbList.length; i++) {
			mbList[i] = new Member();
		}
		
		String data1_temp[] = data1.split(",");
		String data2_temp[] = data2.split(",");
		
		
		for (int i = 0; i < mbList.length; i++) {
			String data1_temp2[] = data1_temp[i].split("/");
			String data2_temp2[] = data2_temp[i].split("/");
			
			
			mbList[i].no = Integer.parseInt(data1_temp2[0]);
			mbList[i].point = Integer.parseInt(data1_temp2[1]);
			if(mbList[i].point > 3) {
				mbList[i].best = true;
			}
			mbList[i].name = data2_temp2[1];
			
		}
		  
		
		for (int i = 0; i < data2_temp.length; i++) {
			System.out.println(mbList[i].no+"/"+mbList[i].name + " : " + mbList[i].point);
			if(mbList[i].best == true) {
				System.out.println(">> BEST");
			}
		}
		
		
		
		
	}

}
