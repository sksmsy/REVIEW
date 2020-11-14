package step8;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Manager1to50Ver2{
	Scanner sc = new Scanner(System.in);
	Vector<Vector<Node1to50>> nodeList;
	int data[][];
	int back_data[][];
	final int SIZE = 5;
	
	void dataInit() {
		data = new int[SIZE][SIZE];
		back_data = new int[SIZE][SIZE];
		int num = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				data[i][j] = num;
				back_data[i][j] = num+25;
				num += 1;
			}
		}
	}
	
	void dataShuffle(){
		Random ran = new Random();
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(SIZE);
			int r2 = ran.nextInt(SIZE);
			
			int temp = data[r][r2];
			data[r][r2]= data[0][0];
			data[0][0] = temp;
			
			for (int j = 0; j < 10; j++) {				
				temp = back_data[r][r2];
				back_data[r][r2] = back_data[0][0];
				back_data[0][0] = temp;
			}
			
		}
	}
	
	void nodeInit() {
		nodeList = new Vector<>();
		
		for (int i = 0; i < SIZE; i++) {
			Vector<Node1to50> temp = new Vector<>();
			
			for (int j = 0; j < SIZE; j++) {
				Node1to50 node = new Node1to50();
				node.num = data[i][j];
				
				temp.add(node);
			}
			nodeList.add(temp);
		}
	}
	
	void printNodeList() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				nodeList.get(i).get(j).printNode();
			}
			System.out.println("\n");
		}
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
			
			if(nodeList.get(sel1).get(sel2).num == num) {
				if(nodeList.get(sel1).get(sel2).num < 25) {
					nodeList.get(sel1).get(sel2).num = back_data[sel1][sel2];
					num ++;					
				}else {
					nodeList.get(sel1).get(sel2).num = 0;
					num++;
				}
			}
			printNodeList();
			
		}
	}
	
}
public class Ex10 {

	public static void main(String[] args) {
		Manager1to50Ver2 g2 = new Manager1to50Ver2();
		
		g2.init();
		
	}

}
