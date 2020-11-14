package step6_2_methodEx;

import java.util.Random;
import java.util.Scanner;

class TestEx3{
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	void ranScr(int arr[]) {
		
		for (int i = 0; i < arr.length; i++) {
			int r= ran.nextInt(100)+1;
			arr[i] = r;
		}
		System.out.print("R점수 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	void total_avg(int arr[]) {
		int tot = 0;
		for (int i = 0; i < arr.length; i++) {
			tot += arr[i];
		}
		double avg = tot / 5.0;
		
		System.out.println("Total : " + tot + ", Avg : " + avg);
	
	}
	
	void over60(int arr[]){
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 60) {
				cnt ++;
			}
		}
		System.out.println("합격 : " + cnt);
	}
	
	void inputIdx(int arr[]) {
		System.out.print("idx : ");
		int idx = sc.nextInt();
		
		System.out.println(arr[idx]);
	}
	
	void inputScrPrintId(int arr[], int arr2[]) {
		System.out.print("score : " );
		int inScr = sc.nextInt();
		
		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if(inScr == arr[i]) {
				idx = i;
			}
		}
		System.out.println(arr2[idx]);
	}
	
	void inputIdPrintScr(int arr[] , int arr2[]) {
		System.out.print("Id : " );
		int inId = sc.nextInt();
		
		int check = -1;
		for (int i = 0; i < arr.length; i++) {
			if(inId == arr[i]) {
				check = i;
			}
		}
		
		if(check == -1) {
			System.out.println("해당 학번은 존재하지 않습니다.");
		}else {
			System.out.println(arr2[check]);
		}
	}
	
	void top(int arr[], int arr2[]) {
		int topScr = 0;
		int topIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if(topScr < arr[i]) {
				topScr = arr[i];
				topIdx = i;
			}
		}
		
		System.out.println("1등 : " + arr2[topIdx] + ", 점수 : " + topScr);
	}
}
public class Ex10 {

	public static void main(String[] args) {
		
		TestEx3 t = new TestEx3();
		
		int id[]= {1001,1002,1003,1004,1005};
		int scr[] = new int[5];
		
		//ex1) scr배열에 1~100점 사이의 랜덤정수 5개 저장
		
		t.ranScr(scr);
		
		//ex2) 전교생 총점, 평균
		t.total_avg(scr);
		
		// ex3) 성적이 60점 이상, 합격생 수 출력
		t.over60(scr);
		// ex4) 인덱스를 입력받아 성적 출력
		t.inputIdx(scr);

		// ex5) 성적 입력, 인덱스 출력
		t.inputScrPrintId(scr, id);
		// ex6) 학번 입력, 성적 출력
		t.inputIdPrintScr(id, scr);
		
		// ex7) 학번 입력, 성적 출력
		// ++ 예외처리
		t.inputIdPrintScr(id, scr);
		
		// 문제8) 1등학생의 학번과 성적 출력
		// 정답8) 1004번(98점)
		t.top(scr, id);
		
	}

}
