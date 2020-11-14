package step3.Test;

public class test4 {

	public static void main(String[] args) {
		
		//ex1) 배열a, b를 비교해서 둘의합이 짝수 일때만 c에 저장
		
		int a[] = {10, 20, 30, 40, 50};
		int b[] = {13, 54, 17, 42, 1};
		int c[] = new int[5];
		
		int cnt = 0;
		for (int i = 0; i < c.length; i++) {
			if((a[i]+b[i]) % 2 == 0) {
				c[cnt] = (a[i]+b[i]);	
				cnt+= 1;
			}
		}
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}System.out.println();
		
		//ex2) 아래는 시험 결과이다. 시험에 합격한 사람의 번호만 win에 저장( 60이상 합격)
		
		int num[] = {1001, 1002, 1003};
		int scr[] = {50, 83, 78};
		int win[] = {0, 0, 0};
		
		int j = 0;
		for (int i = 0; i < win.length; i++) {
			if(scr[i] >= 60) {
				win[j] = num[i];
				j += 1;
			}
		}
		for (int i = 0; i < win.length; i++) {
			System.out.print(win[i] + " ");
		}System.out.println();
		
		//ex3) 아래는 시험결과이다. 시험에 합격한 사람의 번호만 win2에 저장 (60점 이상 합격)
		
		int data[] = {1001,80, 1002,23, 1003,78};
		int win2[] = new int[3];
		
		j = 0;
		for (int i = 0; i < data.length; i++) {
			if(data[i] > 60 && data[i] < 100) {
				win2[j] = data[i-1];
				j+=1;
			}
		}
		for (int i = 0; i < win2.length; i++) {
			System.out.print(win2[i] +" ");
		}
		
		
	}

}
