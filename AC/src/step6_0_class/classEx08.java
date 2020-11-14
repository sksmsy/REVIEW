package step6_0_class;

import java.util.Scanner;

class Ex08{
	int arr[] = {0,0,1,0,2,0,0,1,0};
}


public class classEx08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Ex08 e = new Ex08();
		
		
		int idx = 0;
		
		
		for (int i = 0; i < e.arr.length; i++) {
			if(e.arr[i] == 2) {
				idx = i;
			}
		}
		
		
		while(true) {
			for (int i = 0; i < e.arr.length; i++) {
				if(e.arr[i] == 2 ) {
					System.out.print("옷 ");
				}
				else {
					System.out.print(e.arr[i] + " ");
				}
			}
			System.out.println();
			
			System.out.print("입력 : ");
			int mv = sc.nextInt();
			
			
			if(mv == 1) {
				if(idx != 0 && e.arr[idx-1] == 1) {
					System.out.println("벽부수기(3)");
					int wall = sc.nextInt();
					if(wall !=3) {
						continue;
					}
				}
				e.arr[idx] = 0;
				idx -= 1;
				if(idx == -1) {
					idx = e.arr.length -1;
				}
				else {
					idx %= e.arr.length;
				}

				e.arr[idx]=2;
			}
			else if(mv == 2) {
				if(idx != e.arr.length-1 && e.arr[idx+1] == 1) {
					System.out.println("벽부수기(3)");
					int wall = sc.nextInt();
					if(wall != 3) {
						continue;
					}
				}
				
				e.arr[idx] = 0;
				idx += 1;
				idx %= e.arr.length;
				e.arr[idx] = 2;
				System.out.println(e.arr.length);
			}
			
			
//			if(mv == 1) {
//
//				
//				if(idx-1 >= 0 && e.arr[idx-1] == 1) {
//					
//					System.out.print("벽 부수기 (3) : ");
//					int wall = sc.nextInt();
//					
//					if(wall != 3) {
//						continue;
//					}
//					
//					e.arr[idx]=0;
//					idx -= 1;
//					
//				}else {
//					if(idx-1 < 0) {
//						e.arr[idx]=0;
//						idx = 8;
//					}else {
//						e.arr[idx]=0;
//						idx -= 1;
//					}
//				}
//
//				
//			}

			
		}
		
	}

}
