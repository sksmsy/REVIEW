//package step7_1;
//
//import java.util.Scanner;
//
//class Subject{
//	String name;
//	int scr;
//}
//
//class Student{
//	Subject[] subject;
//	String name;
//}
//public class Ex03 {
//
//	public static void main(String[] args) {
//	
//		Scanner sc = new Scanner(System.in);
//
//		Student[] list = new Student[3];
//		int cnt = 0;
//		
//		
//		while(true) {
//			for(int i=0; i<cnt; i++) {
//				System.out.println("[" + (i+1) + "]" + list[i].name + "학생>>>");
//				if(list[i].subject != null) {
//					for(int j=0; j<list[i].subject.length; j++) {
//						System.out.println("[" + (j+1) + "]" + list[i].subject[j].name + "과목 = " + list[i].subject[j].scr + "점");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println("[1]학생추가");
//			System.out.println("[2]과목추가");
//			System.out.println("[3]성적추가");
//			
//			int choice = sc.nextInt();
//			
//			if(choice == 1) {
//				System.out.print("이름 : ");
//				String name = sc.next();
//				
//				list[cnt] = new Student();
//				list[cnt].name = name;
//				
//				cnt ++;
//			}else if(choice == 2) {
//				for (int i = 0; i < cnt; i++) {
//					System.out.println("[" + (i+1) + "]" + list[i].name);
//				}
//				System.out.print("선택 : ");
//				int sel = sc.nextInt()-1;
//				
//				System.out.print("과목 : ");
//				String subject = sc.next();
//				
//				if(list[sel].subject == null) {
//					list[sel].subject = new Subject[1];
//					
//					list[sel].subject[0] = new Subject();
//					list[sel].subject[0].name = subject;
//				}else {
//					int size = list[sel].subject.length;
//					Subject[] temp = list[sel].subject;
//					list[sel].subject = new Subject[size+1];
//					
//					for (int i = 0; i < size; i++) {
//						list[sel].subject[i] = temp[i];
//					}
//					
//					list[sel].subject[size] = new Subject();
//					list[sel].subject[size].name = subject;
//					
//					temp = null;
//				}
//				
//			}else if(choice == 3) {
//				for (int i = 0; i < cnt; i++) {
//					System.out.println("["+(i+1)+"]" + list[i].name);
//				}
//				System.out.print("선택 : ");
//				int sel = sc.nextInt()-1;
//				
//				if(list[sel].subject != null) {
//					for (int i = 0; i < list[sel].subject.length; i++) {
//						System.out.println("["+(i+1)+"]"+list[sel].subject[i].name);
//					}
//				}
//				System.out.print("과목 : ");
//				int num = sc.nextInt()-1;
//				
//				System.out.print("성적 : ");
//				int scr = sc.nextInt();
//				
//				list[sel].subject[num].scr = scr;
//			}
//		}
//		
//	}
//
//}
