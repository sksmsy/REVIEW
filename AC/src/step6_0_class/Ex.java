package step6_0_class;

import java.util.Scanner;

// 클래스 : 객체
// ㄴ 1) 변수
// ㄴ 2) 메서드

// 사용자정의 자료형 처럼 구현이 됨
// int, double, char, ... String

// class 키워드를 사용해서 정의를 함
// 클래스명은 대문자로 시작을 함
// ㄴ Scanner, Random, File...

class Member{
	String name = "";
	int age;
	int gender;
	
}

public class Ex {
	public static void main(String[] args) {
		
		Scanner sc; // 스캐너 클래스를 담을 변수를 준비
		sc = new Scanner(System.in);
		
		Member mb;
		mb = new Member();
		mb.name="장윤혁";
		
		Member mb2 = new Member();
		mb.name="김지연";
		
		System.out.println(mb2); // step6.Member@1b6d3586
		

	}

}
