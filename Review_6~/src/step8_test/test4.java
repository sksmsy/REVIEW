package step8_test;

import java.util.Scanner;

// 문제   ==> "1)상  2)하 3)좌 4)우" 를 입력할때마다 해당방향으로 블록전체이동 
// 조건) ==> 1은 지나갈수없다. 

public class test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String data ="";
		data += "2,0,0,0,0,1,0,0,0,0\n";
		data += "2,0,0,0,0,1,0,0,0,0\n";
		data += "2,2,2,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,0,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,0,0,0,0,0\n";
		
		final int SIZE = 10;
		
		String map[][] = new String[SIZE][SIZE];
		
		int y[] = new int[5];
		int x[] = new int[5];
		
		String temp [] = data.split("\n");
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split(",");
			
			for (int j = 0; j < temp2.length; j++) {
				map[i][j] = temp2[j];
			}
		}
	
		
		String block = "";
		block += "2,0,0\n";
		block += "2,0,0\n";
		block += "2,2,2\n";
		
		
		int cnt = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(map[i][j].equals("2")) {
					y[cnt] = i;
					x[cnt] = j;
					cnt ++;
				}
			}
		}

		while(true) {
			int my[] = y;
			int mx[] = x;
			
			
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			for (int i = 0; i < x.length; i++) {
				System.out.println(y[i] +":"+x[i]);
			}
			
			System.out.println("2468>>>");
			int mv = sc.nextInt();
			
			if(mv == 2) {
				for (int i = 0; i < mx.length; i++) {
					my[i] += 1;
				}
			}
			
			
			for (int i = 0; i < 5; i++) {
				map[y[i]][x[i]] ="0";
				map[my[i]][mx[i]] ="2";
			}
		
				
			
			
			y = my;
			x = mx;
			
		}

	}
}
