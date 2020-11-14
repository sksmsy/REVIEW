package step6_0_class;

import java.util.Scanner;

class Ex12{
	
	int ladder[][]= {
			{0,0,0,0,0},
			{1,1,0,1,1},
			{0,0,0,0,0},
			{0,0,1,1,0},
			{1,1,0,1,1},
			{0,1,1,0,0},
			{0,0,1,1,0},
			{0,0,0,1,1},
			{0,0,0,0,0}};
	
	int x = 0; int y = 0;
	
	String[] menu = {"aaa", "bbb", "ccc", "ddd", "eee"};
}

public class classEx12 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Ex12 e = new Ex12();
		
		
		for (int i = 0; i < e.ladder.length; i++) {
			for (int j = 0; j < e.ladder[i].length; j++) {
				if(e.ladder[i][j] == 0) {
					System.out.print(" ┃ ");
				}
				else if(j+1 < 5 && e.ladder[i][j+1] == 1) {
					System.out.print(" ┣━");
				}
				else if(j-1 >= 0 && e.ladder[i][j-1] == 1) {
					System.out.print("━┫ ");
				}
			}
			System.out.println();
		}
		
		System.out.print("입력(1~5) : ");
		int my = sc.nextInt();
		
		e.x = my-1;
		

		for (int i = 0; i < e.ladder.length; i++) {
			
			if(e.ladder[e.y][e.x] == 1) {
				
				if(e.x != 0 && e.ladder[e.y][e.x-1] == 1 ) {
					e.x -= 1;
				}
				
				else if(e.ladder[e.y][e.x+1]== 1 && e.x != 4) {
					e.x += 1;
				}
			}
			e.y +=1;
		}
		
		System.out.println(e.menu[e.x]);
			
	}

}
