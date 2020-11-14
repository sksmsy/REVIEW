package step8;

import java.util.Scanner;

class MyList{
	int [] arr;
	int cnt;
	
	void print() {
		System.out.print("[");
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i]);
			if(i != cnt -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	void add(int value) {
		if(cnt == 0) {
			arr = new int[cnt+1];
		}else if(cnt > 0) {
			int [] temp = arr;
			arr = new int[cnt+1];
			
			for (int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}
			temp = null;
		}
		
		arr[cnt] = value;
		cnt += 1;
	}
	
	void add(int idx, int value) {
		if(cnt == 0) {
			arr = new int[cnt+1];
		}else if(cnt > 0) {
			int [] temp = arr;
			arr = new int[cnt+1];
			
			int j = 0;
			for (int i = 0; i < cnt+1; i++) {
				if(i != idx) {
					arr[i] = temp[j];
					j += 1;
				}
			}
			temp = null;
		}
		
		arr[idx] = value;
		cnt += 1;
	}
	
	void remove(int idx) {
		if(cnt == 1) {
			arr = null;
		}else if(cnt > 1) {
			int [] temp = arr;
			arr = new int[cnt-1];
			
			int j = 0;
			for (int i = 0; i < cnt; i++) {
				if(i != idx) {
					arr[j] = temp[i];
					j += 1;
				}
			}
			temp = null;
		}
		cnt -= 1;
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
		arr= null;
		cnt = 0;
	}
}
public class Ex03 {
	public static void main(String[] args) {
		MyList ml = new MyList();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			ml.print();
			
			System.out.println("1.추가 2.삭제 3.삽입 4.종료");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.println("추가 숫자 >>");
				int num = sc.nextInt();
				ml.add(num);
				
			}else if(sel ==2) {
				ml.print();
				System.out.println("삭제할 인덱스 >> ");
				int idx = sc.nextInt();
				if(ml.size() <= 0) {
					continue;
				}
				if(idx <0) {
					continue;
				}
				if(idx >= ml.size()) continue;
				
				ml.remove(idx);
			}else if(sel == 3) {
				ml.print();
				System.out.println("삽입위치 >>>");
				int pos= sc.nextInt();
				System.out.println("삽입 값 >>>");
				int value = sc.nextInt();
				
				ml.add(pos, value);
			}else if(sel == 4) {
				System.out.println("종료");
				break;
			}
		}
		sc.close();
	}
}
