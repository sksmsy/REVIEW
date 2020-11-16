package step8;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
			System.out.println(list);
			System.out.println("1.add 2.delete 3.insert 4.close");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("Insert Num >>>");
				int num = sc.nextInt();
				
				list.add(num);
			}
			else if(sel == 2){
				System.out.print("Remove idx >>>");
				int idx = sc.nextInt();
				list.remove(idx);
			}
			else if(sel == 3) {
				System.out.print("Insert Idx >>>");
				int idx = sc.nextInt();
				
				System.out.print("Insert Num >>>");
				int num = sc.nextInt();
				
				list.add(idx, num);
			}
			else if(sel == 4 ) {
				break;
			}
			
		}
	}

}
