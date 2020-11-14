package step6_0_class;

import java.util.Random;
import java.util.Scanner;

class Ex04{
	int id[] = {1001,1002,1003,1004,1005};
	int scr[] = new int [5];
}

public class classEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		Ex04 e = new Ex04();
		
		//ex1 ) scr배열에 1~100점 사이의 정수 5개 저장
		
		for (int i = 0; i < e.scr.length; i++) {
			int r = ran.nextInt(100)+1;
			e.scr[i] =r;
			System.out.print(e.scr[i] + " ");
		}
		System.out.println();
		
		
		//ex2) 전교생의 총점과 평균 출력
		int tot = 0 ;
		double avg;
		
		for (int i = 0; i < e.scr.length; i++) {
			tot += e.scr[i];
		}
		avg = tot / 5.0;
		System.out.println("total = "+tot + ", " + "avg = " + avg);
		
		
		//ex3) 성적이 60점이상 합격, 합격생 수 출력
		
		int cnt = 0;
		
		for (int i = 0; i < e.scr.length; i++) {
			if(e.scr[i] >= 60) {
				cnt ++;
			}
		}
		System.out.println(cnt);
		
		//ex4) 인덱스를 입력받아 성적 출력
		System.out.print("idx : ");
		int idx = sc.nextInt();
		
		System.out.println(e.scr[idx]);
		
		//ex5) 성적을 입력받아 인덱스출력
		
		System.out.println("score : ");
		int score = sc.nextInt();
		
		for (int i = 0; i < e.scr.length; i++) {
			if(score == e.scr[i]) {
				System.out.println(i);
			}
		}
		
		
		//ex6)학번을 입력받아 성적 출력
		System.out.println("ID : ");
		int myId = sc.nextInt();
		
		for (int i = 0; i < e.id.length; i++) {
			if(myId == e.id[i]) {
				System.out.println(e.scr[i]);
			}
		}
		
		//ex7)학번을 입력받아 성적출력 , 없는학번 입력시 예외처리
		System.out.println("ID : ");
		myId = sc.nextInt();
		int check = -1;
		for (int i = 0; i < e.id.length; i++) {
			if(myId == e.id[i]) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("해당학번은 존재하지 않습니다.");
		} else{
			System.out.println(e.scr[check]);
		}
		
		
		//ex8) 1등학생과 성적 출력
		int top = 0;
		int topIdx =0;
		for (int i = 0; i < e.scr.length; i++) {
			if(top < e.scr[i]) {
				top = e.scr[i];
				topIdx = i;
			}
		}
		
		System.out.println("top : " + e.id[topIdx] + " : " + top);
		
		
	}

}
