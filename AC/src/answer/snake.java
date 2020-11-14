package answer;

import java.util.Scanner;

public class snake {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 10;
		int[][] map = new int[SIZE][SIZE];
		
		int[] y = new int[4];	// 0 0 0 0
		int[] x = new int[4];	// 0 1 2 3

		int[] snake = new int[4];
		
		for(int i=0; i<4; i++) {
			x[i] = i;			
			map[y[i]][x[i]] = i+1;
			snake[i] = map[y[i]][x[i]];
		}	
		
		while(true) {
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.print("1)left 2)right 3)up 4)down : ");
			int move = scan.nextInt();
		
			int nexty= 0;
			int nextx = 0;
			
			if(move == 1) {
				nexty= y[0];
				nextx  = x[0] - 1;
			}
			else if(move == 2) {
				nexty= y[0];
				nextx = x[0] + 1;
			}
			else if(move == 3) {
				nexty= y[0] - 1;
				nextx = x[0];
			}
			else if(move == 4) {
				nexty= y[0] + 1;
				nextx = x[0];
			}

			if(nexty< 0 || nextx  < 0) { continue; }
			if(nexty>= SIZE || nextx >= SIZE) { continue; }

			if(map[nexty][nextx ] != 0) { continue; } 
			
			// 꼬리 지우기
			int taily= y[y.length-1];
			int tailx = x[x.length-1];		
			map[taily][tailx ] = 0;
			

			// 몸통 이동하기(머리빼고)
			for(int i=snake.length-1; i>0; i--) {
				y[i] = y[i - 1];
				x[i] = x[i - 1];
			}

            // 머리이동
			x[0] = nextx ;
			y[0] = nexty;
			
			// 뱀 그리기 
			for(int i=0; i<snake.length; i++) {
				map[y[i]][x[i]] = i + 1;
			}
			
			
		}


	}

}
