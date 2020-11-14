package step8;

import java.util.Scanner;

class MyList{
	
	int [] arr;
	int cnt ;
	
	void print() {
		System.out.print("[");
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i]);
			if(i != cnt - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	void add(int value) {
		if (cnt == 0) {
			arr = new int[cnt + 1];
		}
		else if(cnt > 0) {
			int temp [] = arr;
			arr = new int [ cnt + 1];
			
			for (int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}
			temp = null;
		}
		arr[cnt] = value;
		cnt++;
	}
	
	void add(int idx , int value) {
		if(cnt == 0) {
			arr = new int [cnt + 1];
		}else if(cnt > 0) {
			int [] temp = arr;
			arr = new int [cnt+1];
			
			int j = 0;
			
			for (int i = 0; i < cnt + 1; i++) {
				if(i != idx) {
					arr[i] = temp[j];
					j++;
				}
			}
			
			temp = null;
		}
		
		arr[idx] = value;
		cnt++;
	}
	
	void remove(int idx) {
		if(cnt == 1) {
			arr = null;
		}
		else if(cnt > 1) {
			int [] temp = arr;
			arr = new int[cnt - 1];
			
			int j = 0 ;
			for (int i = 0; i < temp.length; i++) {
				if(i != idx) {
					arr[j] = temp[i];
					j++;
				}
			}
			temp = null;
		}
		cnt --;
	}
	
	int size() {
		return cnt;
	}
	
	int get(int idx) {
		return arr[idx];
	}
	
	void set(int idx, int value) {
		arr[idx] = value;
	}
	
	void clear() {
		arr = null;
		cnt = 0;
	}
	
}
public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyList ml = new MyList();
		
		
		while(true) {
			ml.print();
			
			System.out.println("1.Add 2.Remove 3.Insert 4.clear 5.close");
			System.out.print(">>>");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("Add Value >>>");
				int num = sc.nextInt();
				
				ml.add(num);
			}
			else if(sel == 2) {
				System.out.print("Remove Index >>>");
				int idx = sc.nextInt();
				
				ml.remove(idx);
			}
			else if(sel == 3) {
				System.out.print("Insert Index >>>");
				int idx = sc.nextInt();
				System.out.print("Insert Value >>>");
				int num = sc.nextInt();
				
				ml.add(idx, num);
			}
			else if(sel == 4) {
				ml.clear();
			}
			else if(sel == 5) {
				System.out.println("close");
				break;
			}
			
		}
		
	
	}

}
