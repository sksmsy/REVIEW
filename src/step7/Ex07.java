package step7;

import java.util.Random;

class Horse{
	String name = "";
	int pos; int rank;
	boolean win = false;
}

class Racing{
	Random ran = new Random();
	
	Horse arr[] = new Horse[4];
	
	int size = 4;
	int line = 20;
	int track [][] = new int[size][line];

	void run() {
		String name ="abcd";
		for (int i = 0; i < size; i++) {
			arr[i] = new Horse();
			arr[i].name = name.charAt(i)+"";
		}
		
		Play();
		print();
	}
	
	void print() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < line; j++) {
				if(arr[i].pos == j) {
					System.out.print("["+arr[i].name+"]");
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
			print();
			
			for (int i = 0; i < size; i++) {
				if(arr[i].win == true) continue;
				
				int r = ran.nextInt(2)+1;
				arr[i].pos += r;
				if(arr[i].pos >= 19) {
					arr[i].pos = 19;
					arr[i].win = true;
					arr[i].rank = cnt+1;
					cnt ++;
				}
				if(cnt >= size) {
					loop = false;
					break;
				}
				
				
			}
			try {
				Thread.sleep(800);
			} catch (Exception e) {}
		}
	}
	
}
public class Ex07 {
	public static void main(String[] args) {
		Racing race = new Racing();
		
		race.run();
	}
}
