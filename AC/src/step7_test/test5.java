//package step7_test;
//
//import java.util.Random;
//
//class Horse{
//	String name=""; 
//	int pos = 0;
//	int rank = 0;
//	boolean win = false;
//}
//
//class Racing{
//	Random ran = new Random();
//	int size = 4;
//	Horse[] arr = new Horse[size];
//	int line = 20;
//	int track[][] = new int[size][line];
//	
//	
//	
//	void run() {
//		String name = "ABCD";
//		for (int i = 0; i < size; i++) {
//			arr[i] = new Horse();
//			arr[i].name = name.charAt(i) + "";
//		}
//		Play();
//		Print();
//	}
//	
//	void Print() {
//		System.out.println();
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < line; j++) {
//				if(arr[i].pos == j) {
//					System.out.print("["+arr[i].name+"]");
//				}else {
//					System.out.print("[ ]");
//				}
//			}
//			System.out.println();
//		}
//	}
//	
//	void Play() {
//		boolean loop = true;
//		int cnt = 0;
//		
//		while(loop) {
//			Print();
//			for (int i = 0; i < size; i++) {
//				if(arr[i].win == true) continue;
//				int r = ran.nextInt(3)+1;
//				
//				arr[i].pos += r;
//				
//				if(arr[i].pos >= 19) {
//					arr[i].pos = 19;
//					arr[i].rank = cnt+1;
//					arr[i].win = true;
//					cnt += 1;
//					if(cnt >= size) {
//						loop = false;
//						break;
//					}
//				}
//			}
//			try {
//				Thread.sleep(800);
//			} catch (Exception e) {}
//		}
//	}
//	
//
//	
//	
//}
//
//
//public class test5 {
//
//	public static void main(String[] args) {
//		Racing race = new Racing();
//		
//		race.run();
//		
//	}
//
//}
