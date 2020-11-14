package step7_1;

import java.util.Scanner;



class Stu{
	String name;
	Sub [] sub;
}

class Sub{
	String name;
	int scr;
	
}


public class Ex03_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stu list [] = new Stu[3];
		int cnt = 0;
		
		while(true) {
			for (int i = 0; i < cnt; i++) {
				System.out.println("["+(i+1)+"]"+list[i].name);
				if(list[i].sub != null) {
					for (int j = 0; j < list[i].sub.length; j++) {
						System.out.println("["+(j+1)+"]" + list[i].sub[j].name + " > " + list[i].sub[j].scr);
					}
				}
				System.out.println();
			}
			
			System.out.println("[1]학생추가");
			System.out.println("[2]과목추가");
			System.out.println("[3]성적추가");
			System.out.print(">>>");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("이름 : ");
				String name = sc.next();
				
				list[cnt] = new Stu();
				list[cnt].name = name;
				cnt++;
			}
			else if(sel == 2){
				for (int i = 0; i < cnt; i++) {
					System.out.println("["+(i+1)+"]" + list[i].name);
				}
				System.out.print(">>>");
				int num = sc.nextInt()-1;
				
				System.out.print("과목 : ");
				String subj = sc.next();
				
				if(list[num].sub == null) {
					list[num].sub = new Sub[1];
					
					list[num].sub[0] = new Sub();
					list[num].sub[0].name = subj;
				}else {
					int size = list[num].sub.length;
					
					Sub temp [] = list[num].sub;
					list[num].sub = new Sub[size+1];
					
					for (int i = 0; i < temp.length; i++) {
						list[num].sub[i] = temp[i];
					}
					
					list[num].sub[size] = new Sub();
					list[num].sub[size].name = subj;
				}
			}
			else if(sel == 3) {
				for (int i = 0; i < cnt; i++) {
					
					System.out.println("["+(i+1)+"]"+list[i].name );
				}
				System.out.print("학생 >>>");
				int num = sc.nextInt()-1;
				
				if(list[num].sub != null) {
					for (int i = 0; i < list[num].sub.length; i++) {
						System.out.println("["+(i+1)+"]"+list[num].sub[i].name);
					}
				}
				System.out.print("과목 >>>");
				int num2 = sc.nextInt()-1;
				
				System.out.print("점수 >>>");
				int scr = sc.nextInt();
				
				
				list[num].sub[num2].scr = scr;
				
			}
		}
		
		
	}

}
