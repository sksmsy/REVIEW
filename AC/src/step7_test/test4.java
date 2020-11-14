package step7_test;

import java.util.Random;

class Lott{
	int [] data = new int[8];
	boolean win = false;
	void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
}

public class test4 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		Lott [] arr = new Lott[5];
		
		boolean check = false;
		
		int n = 0;
		while(n < 5) {
			
			arr[n] = new Lott();
			
			for (int i = 0; i < arr[n].data.length; i++) {
				int r = ran.nextInt(2);
				
				if(r == 1) {
					arr[n].data[i] = 3;
				}else {
					arr[n].data[i] = 0;
				}
			}
			
			
			int cnt = 0;
			for (int i = 0; i < arr[n].data.length; i++) {
				if(arr[n].data[i] == 3) {
					cnt += 1 ;
					
					if(cnt == 3) {
						arr[n].win = true;
						break;
					}
				}else {
					cnt = 0;
				}
			}
			
			
			if(check == false && arr[n].win == true) {
				check = true;
				
				n+= 1;
			}else if(check == true && arr[n].win == false) {
				n+=1;
			}
			
		}
			

		for (int i = 0; i < 10; i++) {
			int r = ran.nextInt(5);
			
			Lott temp = arr[0];
			arr[0] = arr[r];
			arr[r] = temp;
		}
		
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i].print();
		}
		
	}
}


//1700
//1725