package step8_test;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Subject{
	String name;
	int scr;
	
	void print() {
		System.out.println(name +" : "+scr);
	}
}

class SubjectManager{
	Vector<Subject> subList;
	
	
	void add_data(Subject sb) {
		
		subList.add(sb);
	}
	
	void remove_data(int idx){
		subList.remove(idx);
	}
	
	void printAll() {
		for (int i = 0; i < subList.size(); i++) {
			System.out.print("["+(i+1)+"]");
			subList.get(i).print();
		}
	}
	
}

class Student{
	String name;
	int num;
	SubjectManager subm;
	
	void print() {
		System.out.println(name + " : " + num);
	}
	
}

class StudentManager{
	Vector<Student> stuList;

	
	String set_data() {
		Random ran = new Random();
		String name = "";
		
		String name1[] = {"가","나","다","라","마"};
		String name2[] = {"가","나","다","라","마"};
		String name3[] = {"가","나","다","라","마"};
		
		int r = ran.nextInt(name1.length);
		name += name1[r];
		r = ran.nextInt(name1.length);
		name += name2[r];
		r = ran.nextInt(name1.length);
		name += name3[r];
		
		return name;
	}
	
	void Init() {
		stuList = new Vector<>();
		int num = 1001;
		for (int i = 0; i < 5; i++) {
			Student st = new Student();
			
			st.name = set_data();
			st.num = num + i;
			
			st.subm = new SubjectManager();
			st.subm.subList = new Vector<>();
			stuList.add(st);
		}
	}
	
	int checkId(String a) {
		int check = -1;
		for (int i = 0; i < stuList.size(); i++) {
			if(a.equals(stuList.get(i).name)) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	void printStudent() {
		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).print();
		}
	}
	
}


public class test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		
		sm.Init();
		
		int log = -1;
		while(true) {
			System.out.println("----------");
			sm.printStudent();
			System.out.println("----------");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]과목 추가/삭제");
			System.out.println("[0]종료");
			System.out.print(">>>");
			
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(log > -1) {
					continue;
				}
				System.out.print("NAME >");
				String id = sc.next();
				
				int check = sm.checkId(id);
				
				if(check == -1) {
					System.out.println("해당 학생은 존재하지 않습니다.");
				}
				else {
					System.out.println(sm.stuList.get(check).name + "님 로그인");
					log = check;
				}
			}
			else if(sel == 2) {
				System.out.println(sm.stuList.get(log).name + "님 로그아웃");
				log = -1;
			}
			else if(sel ==3) {
				
				while(true) {
					System.out.println("---------");
					sm.stuList.get(log).subm.printAll();
					System.out.println("---------");
					System.out.println("[1]추가");
					System.out.println("[2]삭제");
					System.out.println("[0]이전");
					System.out.print(">>>");
					int sel2 = sc.nextInt();
					
					if(sel2 == 1) {
						Subject temp = new Subject();
						 System.out.print("Name >");
						 temp.name = sc.next();
						 System.out.print("Score >");
						 temp.scr = sc.nextInt();
						 
						 sm.stuList.get(log).subm.add_data(temp);
					}
					else if(sel2 ==2) {
						System.out.println("삭제할 번호 >");
						int delIdx = sc.nextInt()-1;
						
						sm.stuList.get(log).subm.remove_data(delIdx);
					}
					else if(sel2 == 0) {
						break;
					}
				}
			}
			else if(sel == 0) {
				break;
			}
			
		}
	}

}
