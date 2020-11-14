package step8;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Node1to50{
	int num;
	
	void printNode() {
		System.out.print(num + "\t");
	}
}

class Manager1to50{
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);	
	
	Vector<Node1to50[]> nodeList;
	int data[][] ;
	final int SIZE = 5;
	
	void dataInit() {
		data = new int[SIZE][SIZE];
		int num = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				data[i][j] = num;
				
				num+= 1;
			}
		}
	}
	
	void dataShuffle() {
		for (int i = 0; i < 100; i++) {
			for (int k = 0; k < data.length; k++) {
				int r = ran.nextInt(SIZE);
				int r2= ran.nextInt(SIZE);
				
				int temp  = data[0][0];
				data[0][0] = data[r][r2];
				data[r][r2] = temp;
			}
		}
	}
	
	void nodeInit() {
		nodeList = new Vector<>();
		
		for (int i = 0; i < SIZE; i++) {
			Node1to50[] temp  = new Node1to50[SIZE];
			for (int j = 0; j < SIZE; j++) {
				Node1to50 node = new Node1to50();
				node.num = data[i][j];
				
				temp[j] = node;
			}
			nodeList.add(temp);
		}
	}
	
	void printNodeList() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				nodeList.get(i)[j].printNode();	
			}
			System.out.println();
		}
		System.out.println();
	}
	
	void init() {
		dataInit();
		dataShuffle();
		nodeInit();
		printNodeList();
		
		int num = 1;
		
		while(num<50) {
			
			System.out.print("Y : ");
			int sel1 = sc.nextInt();
			System.out.print("X : ");
			int sel2 = sc.nextInt();
			
			if(nodeList.get(sel1)[sel2].num == num) {
				if(nodeList.get(sel1)[sel2].num < 25) {
					nodeList.get(sel1)[sel2].num = num + 25;
					num ++;					
				}else {
					nodeList.get(sel1)[sel2].num = 0;
					num++;
				}
			}
			printNodeList();
			
		}
	}


		
		
}
public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Manager1to50 m = new Manager1to50();
		
		m.init();
		

		
	}

}
