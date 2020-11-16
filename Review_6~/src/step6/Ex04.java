package step6;

import java.util.Random;
import java.util.Scanner;

class Ex4{
	int id[] = {1001, 1002, 1003, 1004, 1005};
	int scr[] = new int[5];
}
public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		
		Ex4 e = new Ex4();
		
		//ex1) scr배열에 1~100점 사이 정수 저
		for (int i = 0; i < e.scr.length; i++) {
			int r = ran.nextInt(100)+1;
			
			e.scr[i] = r;
		}

		//ex2) 전교생의 총점과 평균
		
		int tot = 0;
		for (int i = 0; i < e.scr.length; i++) {
			tot += e.scr[i];
		}
		double avg = tot / 5.0;
		System.out.println(tot + ", " + avg);

		//ex3) 성적이 60점 이상 합격 ,합격생 수 출력
		int cnt = 0;
		for (int i = 0; i < e.scr.length; i++) {
			if(e.scr[i] >= 60) {
				cnt ++;
			}
		}
		System.out.println(cnt +"명");
		
		//ex4) 인덱스를 입력받아 성적 출력
		System.out.print("idx : ");
		int my = sc.nextInt();
		
		System.out.println(e.scr[my]);
		
		
		//ex5)성적을 입력받아 인덱스 출력
		System.out.print("scr : ");
		int scr = sc.nextInt();
		
		int idx =0;
		for (int i = 0; i < e.scr.length; i++) {
			if(scr == e.scr[i]) {
				idx = i;
			}
		}
		System.out.println("idx : " + idx);
		
		
		//ex6, 7)학번을 입력받아 성적 출력 / 7) 예외처
		System.out.print("id : ");
		int myId = sc.nextInt();
		
		int check = -1;
		for (int i = 0; i < e.scr.length; i++) {
			if(myId == e.id[i]) {
				check =i;
			}
		}
		
		if(check == -1) {
			System.out.println("없는학번입니다.");
		}else {
			System.out.println(e.scr[check]);
		}
		
		//ex8) 1등 학생, 학번 출력
		int top = 0;
		int topIdx = -1;
		
		for (int i = 0; i < e.scr.length; i++) {
			if(top < e.scr[i]) {
				top = e.scr[i];
				topIdx = i;
			}
		}
		System.out.println(top + " : " + e.id[topIdx]);
		
		
	}
}
