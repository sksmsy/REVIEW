package step8_test;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

//1to50


class Node1to50{
	int num;
	
	void print() {
		System.out.print(num +"\t");
	}
}

class Manager1to50{
	Vector<Node1to50[]> list;
	int data[][];
	int back[][];
	
	final int SIZE = 5;
	
	void dataInit() {
		data = new int[SIZE][SIZE];
		back = new int[SIZE][SIZE];
		
		int num = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				data[i][j] = num;
				back[i][j] = num+25;
				num++;
			}
		}
	}

	void shuffle() {
		Random ran = new Random();
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(SIZE);
			int r2 = ran.nextInt(SIZE);
			
			int temp = data[r][r2];
			data[r][r2] = data[0][0];
			data[0][0] = temp;
			
		}
		for (int j = 0; j < 100; j++) {
			int r = ran.nextInt(SIZE);
			int r2 = ran.nextInt(SIZE);
			
			int temp = back[r][r2];
			back[r][r2] = back[0][0];
			back[0][0] = temp;
		}
	}

	void nodeInit() {
		list = new Vector<>();
		
		for (int i = 0; i < SIZE; i++) {
			Node1to50 temp[] = new Node1to50[SIZE];
			for (int k = 0; k < SIZE; k++) {
				Node1to50 node = new Node1to50();
				node.num = data[i][k];
				
				temp[k] = node;
			}
			list.add(temp);
		}
	}
	
	void Init() {
		dataInit();
		shuffle();
		nodeInit();
	}
		
	void printNum() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j <SIZE; j++) {
				list.get(i)[j].print();
			}
			System.out.println("\n");
		}
	}
	
	
	
}



public class test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Manager1to50 m = new Manager1to50();
		
		m.Init();
		m.printNum();
		
		int num = 1;
		while(true) {
			System.out.println("["+num+"]");
			
			System.out.print("Y > ");
			int y = sc.nextInt();
			System.out.print("X > ");
			int x = sc.nextInt();
			
			
			if(m.list.get(y)[x].num == num) {
				
				if(num <= 25) {
					m.list.get(y)[x].num = m.back[y][x];
				}else {
					m.list.get(y)[x].num = 0;
				}
				num++;
			}
			
			if(num == 50) {
				break;
			}
			m.printNum();
		}
		
		
		
	}
}
