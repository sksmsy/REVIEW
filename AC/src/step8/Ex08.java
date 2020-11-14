//package step8;
//
//import java.util.Random;
//import java.util.Scanner;
//import java.util.Vector;
//
//class Node{
//	int front;
//	int back;
//}
//
//class MemoryGame{
//	Vector<Node> nodeList;
//	int data[];
//	final int SIZE = 10;
//	Scanner sc = new Scanner(System.in);
//	
//	void shuffle() {
//		Random ran = new Random();
//		for (int i = 0; i < 100; i++) {
//			int r = ran.nextInt(data.length);
//			int temp = data[r];
//			data[r] = data[0];
//			data[0] = temp;
//		}
//	}
//	
//	void dataInit() {
//		data = new int[SIZE];
//		for (int i = 0; i < SIZE; i++) {
//			data[i] = (i + 2) /2;
//		}
//	}
//	
//	void nodeInit() {
//		nodeList = new Vector<>();
//		for (int i = 0; i < SIZE; i++) {
//			Node node = new Node();
//			node.front = data[i];
//			nodeList.add(node);
//		}
//	}
//	
//	void init() {
//		dataInit();
//		shuffle();
//		nodeInit();
//	}
//	
//	void print() {
//		System.out.println("------------------------------");
//		for (int i = 0; i < SIZE; i++) {
//			if(nodeList.get(i).back == 0) {
//				System.out.print("[ ]");
//			}else {
//				System.out.print("["+ nodeList.get(i).back+"]");
//			}
//		}System.out.println();
//		System.out.println("------------------------------");
//	}
//	
//	void updata() {
//		while(true) {
//			print();
//			System.out.println("idx1(0~9) : ");
//			int sel1 = sc.nextInt();
//			System.out.println("idx2(0~9) : ");
//			int sel2 = sc.nextInt();
//			nodeList.get(sel1).back = nodeList.get(sel1).front;
//			nodeList.get(sel2).back = nodeList.get(sel2).front;
//			print();
//			
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if(nodeList.get(sel1).back != nodeList.get(sel2).back) {
//				nodeList.get(sel1).back = 0;
//				nodeList.get(sel2).back = 0;
//			}
//		}
//	}
//}
//public class Ex08 {
//	public static void main(String[] args) {
//		MemoryGame mg = new MemoryGame();
//		mg.init();
//		mg.updata();
//	}
//}
