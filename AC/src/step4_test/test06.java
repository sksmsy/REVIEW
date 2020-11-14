package step4_test;

public class test06 {

	public static void main(String[] args) {

		
		int size = 5;
		int map [][] = new int[5][5];
		boolean check [][] = new boolean[5][5];
		
		int x = 0;
		int y = 0;
		int num = 1;
		int dir = 1;
		
		
		map[y][x] = num;
		check[y][x] = true;
		
		for (int i = 0; i < 24; i++) {
			int yy = y;
			int xx = x;
			
			if(dir == 1) {
				xx =xx + 1;
			}else if(dir == 2 ) {
				yy = yy + 1;
			}else if(dir == 3) {
				xx = xx - 1;
			}else if (dir == 4) {
				yy = yy -1;
			}
			
			if(size <= xx || xx < 0 || size <= yy || yy<0 || check[yy][xx] == true) {
				dir = dir + 1;
				
				xx = x; 
				yy = y;
				
				if(dir == 5) {
					dir = 1;
				}
				
				if(dir == 1) {
					xx = xx + 1;
				}else if(dir == 2) {
					yy = yy+ 1;
				}else if(dir == 3) {
					xx = xx -1;
				}else if(dir == 4) {
					yy = yy -1;
				}
				
			}
			
			num = num + 1;
			
			y =  yy;
			x = xx;
			
			map[y][x] = num;
			check[y][x] = true;
			
			System.out.println("y = " + y + ", x="+x );
			
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(check[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();


	}

}
