package step7;

import java.util.Random;

class Lott{
	int [] data = new int[8];
	boolean win = false;
	void print() {
		for (int i = 0; i < 8; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
}

public class Ex06 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		Lott arr[] = new Lott[5];
		boolean check = false;
		
		
		int n = 0;
		while(n <5) {
			arr[n] = new Lott();
			
			for (int i = 0; i < 8; i++) {
				int r = ran.nextInt(2);
				
				if(r == 0) {
					arr[n].data[i] = 0;
				}else {
					arr[n].data[i] = 3;
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				if(arr[n].data[i] == 3) {
					cnt ++;
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
				n += 1;
			}
			else if(check == true && arr[n].win == false) {
				 n+= 1;
			}
				
		}
		for (int i = 0; i < 5; i++) {
			arr[i].print();
			
		}
	}
}
