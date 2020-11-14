package step6;

import java.util.Scanner;

//클래스 + 변수만 사용

class Ex8{
	int arr[] = {0,0,1,0,2,0,0,1,0};
	
}

public class Ex08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Ex8 e = new Ex8();
		
		int idx = 0;
		while(true) {
			
			for (int i = 0; i < e.arr.length; i++) {
				if(e.arr[i] == 2) {
					System.out.print("옷 ");
					idx = i;
				}else if(e.arr[i] == 1) {
					System.out.print("벽 ");
				}else {
					System.out.print(e.arr[i]+" ");
				}
			}
			System.out.println();
			
			System.out.print(">>>");
			int mv= sc.nextInt();
			
			if(mv == 1) {
				if(idx != 0 && e.arr[idx-1] == 1) {
					System.out.print("3 >>");
					int wall = sc.nextInt();
					if(wall != 3) {
						continue;
					}
				}
				
				e.arr[idx] = 0;
				idx --;
				if(idx == -1) {
					idx = e.arr.length-1;
				}
				e.arr[idx] = 2;
			}
			
			else if (mv == 2) {
				if(idx != e.arr.length-1 && e.arr[idx+1] == 1) {
					System.out.print("3 >>");
					int wall = sc.nextInt();
					if(wall != 3) {
						continue;
					}
				}
				
				e.arr[idx] = 0;
				idx ++;
				if(idx == e.arr.length) {
					idx = 0;
				}
				e.arr[idx] = 2;
			}
			
		}
	}
}
