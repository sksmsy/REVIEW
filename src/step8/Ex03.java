package step8;

import java.util.Vector;

public class Ex03 {

	public static void main(String[] args) {
		//Vector == ArrayList
		// ArrayList가 성능이 더 좋음
		
		Vector<Integer> list = new Vector<>();
		
		
		//add(value) : Vector의 맨 뒤 Value를 추가
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		//remove(index) : Vector의 index 데이터를 제거
		list.remove(3);
		System.out.println(list);
		
		//size(); : Vector에 저장된 데이터의 개수 (length)
		int cnt = list.size();
		System.out.println("cnt = " +cnt);
		
		//get(index) : Vector의 index 데이터를 얻어옴
		System.out.print("[");
		for (int i = 0; i < cnt; i++) {
			System.out.print(list.get(i));
			if(i != cnt-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		
		//add(index, value) : Vector의 Index 위치에 Value를 삽입
		list.add(0, 9);
		System.out.println(list);
		
		//set(index, value) : Vector의 Index 위치의 Value를 수정
		list.set(3, 5);
		System.out.println(list);
		
		//clear() : Vector의 모든 데이터를 제거
		list.clear();
		System.out.println(list);
		
	}

}
