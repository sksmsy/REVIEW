package step8;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Sub{
	String name;
	int scr;
	
	void Print() {
		System.out.println(name + " : " + scr);
	}
	
}


class SubManager{
	Vector<Sub> subList;
	
}

class Stu{
	String name;
	int num;
	SubManager sbm;
	
	void studentPrint() {
		System.out.println(num + " : " + name);
	}
	
}

class StuManager{
	Vector <Stu> stuList;
	
	String setRandomName() {
		
		Random ran = new Random();
		
		String name= "";
		String[] name1 = { "김", "이", "박", "최", "정" };
		String[] name2 = { "선", "재", "명", "지", "다" };
		String[] name3 = { "태", "민", "수", "연", "빈" };
		
		int r = ran.nextInt(5);
		name += name1[r];
		r = ran.nextInt(5);
		name += name2[r];
		r = ran.nextInt(5);
		name += name3[r];
		
		return name;
	}
	
	int check_name(String a) {
		int check = -1;
		
		for (int i = 0; i < stuList.size(); i++) {
			if(a.equals(stuList.get(i).name)) {
				check = i;
			}
		}
		return check;
	}
	
	void init() {
		stuList = new Vector<>();
		
		int num = 1001;
		for (int i = 0; i < 5; i++) {
			Stu st = new Stu();
			st.num += (num+i);
			st.name = setRandomName();
			
			st.sbm = new SubManager();
			st.sbm.subList = new Vector<>();
			stuList.add(st);
		}
	}
	
	void printAll() {
		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).studentPrint();
		}
	}
	
	
	
}

public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StuManager sm = new StuManager();
		
		//기능추가
		//1.로그인
		//2. 수강과목 추가/삭제
		
		sm.init();
		
		int log = -1;
		while(true) {
			System.out.println("------------");
			sm.printAll();
			System.out.println("------------");
			
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]과목 추가/삭제");
			System.out.println("[0]종료");
			System.out.print(">>>");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("name : ");
				String id = sc.next();
				
				int check = sm.check_name(id);
				
				if(check == -1) {
					System.out.println("해당 이름은 존재하지 않습니다.");
				}else {
					System.out.println(sm.stuList.get(check).name+ "님 로그인");
					log = check;
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					continue;
				}
				
				System.out.println("로그아웃 완료");
				log = -1;
			}
			else if(sel == 3) {
				if(log == -1) {
					continue;
				}
				
				
				while(true) {
					SubManager subm = sm.stuList.get(log).sbm;
					Sub sb = new Sub();
					
					System.out.println("---------");
					for (int i = 0; i < sm.stuList.get(log).sbm.subList.size(); i++) {
						System.out.println("["+(i+1)+"]");
						sm.stuList.get(log).sbm.subList.get(i).Print();
					}
					System.out.println("---------");
					System.out.println("[1]추가");
					System.out.println("[2]삭제");
					System.out.println("[0]종료");
					int sel2 = sc.nextInt();
					
					if(sel2 == 1) {
						System.out.print("과목이름 : ");
						String subName = sc.next();
						System.out.print("점수 : ");
						int subScr = sc.nextInt();
						sb.name = subName;
						sb.scr = subScr;
						
						sm.stuList.get(log).sbm.subList.add(sb);
					}
					else if(sel2 == 2) {
						System.out.print("삭제 할 과목번호 >>");
						int num = sc.nextInt()-1;
						
						sm.stuList.get(log).sbm.subList.remove(num);
						
						
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
