package step8_test;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Node{
	int front;
	int back;
}

class MemoryGame{
	Scanner sc = new Scanner(System.in);
	Vector<Node> vec = new Vector<Node>();
	int data[];
	
	final int SIZE = 10;
	
	void dataInit() {
		data = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			data[i] = (i+2)/2;
		}
	}
	
	void shuffle() {
		Random ran = new Random();
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(data.length);
			
			int temp = data[r];
			data[r] = data[0];
			data[0] = temp;
		}
	}
	
	void nodeInit() {
		
		for (int i = 0; i < data.length; i++) {
			Node node = new Node();
			node.front = data[i];
			vec.add(node);
		}
	}
	
	void init() {
		dataInit();
		shuffle();
		nodeInit();
	}
	
	void print() {
		System.out.println("------------------------------");
		for (int i = 0; i < vec.size(); i++) {
			if(vec.get(i).back == 0) {
				System.out.print("[ ]");
			}else {
				System.out.print("["+vec.get(i).back+"]");
			}
		}
		System.out.println();
		System.out.println("------------------------------");
	}
	
	void play() {
		
		int cnt = 0;
		while(true) {
			
			if(cnt == 5) {
				break;
			}
			
			print();
			System.out.print("idx1 >");
			int idx1 = sc.nextInt();
			System.out.print("idx2 >");
			int idx2 = sc.nextInt();
			
			vec.get(idx1).back = vec.get(idx1).front;
			vec.get(idx2).back = vec.get(idx2).front;
			
			print();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {e.printStackTrace();}
			
			if(vec.get(idx1).back != vec.get(idx2).back) {
				vec.get(idx1).back = 0;
				vec.get(idx2).back = 0;
			}else {
				cnt ++;
			}
		}
	}
	
}

public class test2 {

	public static void main(String[] args) {

		MemoryGame mg = new MemoryGame();
		
		mg.init();
		mg.play();
	}

}
