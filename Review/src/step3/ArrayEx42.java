package step3;

import java.util.Scanner;

public class ArrayEx42 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int[][] apt = {
				{101, 102, 103},	
				{201, 202, 203},	
				{301, 302, 303}	
			};
			
			int[][] pay = {
				{1000, 2100, 1300},	
				{4100, 2000, 1000},	
				{3000, 1600,  800}
			};

			
			//ex1) 각 층 관리비의 합
			
			for (int i = 0; i < pay.length; i++) {
				int tot = 0;
				for (int j = 0; j < pay[i].length; j++) {
					tot += pay[i][j];
					
				}
				System.out.print(tot+ " ");
			}System.out.println();

			//ex2) 호를 입력하면 관리비 출력
			System.out.print("호 : ");
			int num = scan.nextInt();
			
			for (int i = 0; i < pay.length; i++) {
				for (int j = 0; j < pay[i].length; j++) {
					if(num == apt[i][j]) {
						System.out.println(pay[i][j]);
					}
				}
			}
			
			//ex3) 관리비가 제일 적게 나온집 , 많게나온 집 출력
			
			int maxApt = 0;
			int idx1 = 0, idx2 = 0;
			for (int i = 0; i < pay.length; i++) {
				for (int j = 0; j < pay[i].length; j++) {
					if(maxApt < pay[i][j]) {
						maxApt = pay[i][j];
						idx1 = i;
						idx2 = j;
					}
				}
			}
			System.out.println(apt[idx1][idx2]);
			
			
	
			int minApt = pay[0][0];
			idx1 = 0; idx2 = 0;
			for (int i = 0; i < pay.length; i++) {
				for (int j = 0; j < pay[i].length; j++) {
					if(minApt > pay[i][j]) {
						minApt = pay[i][j];
						idx1 = i;
						idx2 = j;
					}
				}
			}
			System.out.println(apt[idx1][idx2]);
			
			//ex4) 호수를 2개 입력하여 관리비 교체
			
			System.out.print("호1 : ");
			int home1 = scan.nextInt();
			System.out.print("호2 : ");
			int home2 = scan.nextInt();
			
			int idx1_i = 0, idx1_j=0;
			int idx2_i = 0, idx2_j=0;
			
			for (int i = 0; i < pay.length; i++) {
				for (int j = 0; j < pay.length; j++) {
					if(home1 == apt[i][j]) {
						idx1_i = i;
						idx1_j = j;
					}
					
					if(home2 == apt[i][j]) {
						idx2_i = i;
						idx2_j=  j;
					}
				}
			}
			
			int temp = pay[idx1_i][idx1_j];
			pay[idx1_i][idx1_j] = pay[idx2_i][idx2_j];
			pay[idx2_i][idx2_j] = temp;
			
			for (int i = 0; i < pay.length; i++) {
				for (int j = 0; j < pay.length; j++) {
					System.out.print(pay[i][j] + " ");
				}
				System.out.println();
			}
			
	}

}
