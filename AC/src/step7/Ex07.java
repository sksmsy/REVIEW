package step7;

import java.util.Random;

class Hr{
	String name = ""; int pos = 0; int rank = 0;
	boolean win = false;
}

class Racing{
	Random ran = new Random();
	int size = 4;
	Hr [] hr = new Hr[size];
	int line = 20;
	int track[][] = new int[size][line];
	
	void run() {
		String names = "abcd";
		for (int i = 0; i < size; i++) {
			hr[i] = new Hr();
			hr[i].name = names.charAt(i) + "";
		}
		Play();
		PrintHorse();
	}
	void PrintHorse() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < line; j++) {
				if(hr[i].pos == j) {
					System.out.print("["+hr[i].name+"]");
				}else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}
	void Play() {
		boolean loop = true;
		int cnt = 0;
		while(loop) {
			PrintHorse();
			for (int i = 0; i < size; i++) {
				if(hr[i].win == true) continue;
				int r = ran.nextInt(4) + 1;
				hr[i].pos += r;
				if(hr[i].pos >= 19) {
					hr[i].pos = 19;
					hr[i].rank = cnt+ 1;
					hr[i].win = true;
					cnt += 1;
					if(cnt >= size) {
						loop = false;
						break;
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				
			}
		}
	}
	
}


public class Ex07 {

	public static void main(String[] args) {

		Racing race = new Racing();
		
		race.run();
	}

}
