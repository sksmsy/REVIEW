package step8;

import java.util.Vector;

public class Ex04 {
	public static void main(String[] args) {
		//Vector
		
		Vector<Integer> vec = new Vector<>();
		
		//add(value) : Vector의 맨 뒤에 value 를 추가
		vec.add(10);
		vec.add(20);
		vec.add(30);
		vec.add(40);
		vec.add(50);
		System.out.println(vec);
		
		
		//remove(index) : Vector의 index번째 데이터 삭제
		vec.remove(3);
		System.out.println(vec);
		
		//size() : Vector에 저장된 데이터의 개수
		int cnt = vec.size();
		System.out.println("cnt = " + cnt);
		
		//get() : Vector의 index번째 value
		System.out.print("[");
		for (int i = 0; i < cnt; i++) {
			System.out.print(vec.get(i));
			if(i != cnt -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
		
		// add(index , value) : Vector의 index 위치에 value 삽입
		vec.add(0, 100);
		System.out.println(vec);
		
		//set(index, value) : Vector의 index위치에 value를 수정
		vec.set(3, 5);
		System.out.println(vec);
		
		
		//clear() : Vecotr의 모든 데이터를 제거
		vec.clear();
		System.out.println(vec.size());
	}
}
