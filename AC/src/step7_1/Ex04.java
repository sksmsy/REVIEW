package step7_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Student{
	String id = "";
	String pw = "";
	
	void set_data(String i , String p) {
		id = i; pw = p;
	}
	void print_data() {
		System.out.println("ID : " + id + " / PW : " + pw);
	}
}
class Manager{
	
	Student [] list = null;
	int cnt = 0;
	
	void add_student(Student st) {
		if(cnt == 0) {
			list = new Student[1];
		}else {
			Student [] temp = list;
			list = new Student[cnt+1];
			for (int i = 0; i < temp.length; i++) {
				list[i] = temp[i];
			}
			temp = null;;
		}
		
		list[cnt] = st;
		cnt++;
	}
	
	Student remove_student(int index) {
		Student del_st = list[index];
		if(cnt == 1) {
			list = null;
		}else {
			Student[] temp = list;
			list = new Student[cnt -1];
			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			}
			for (int i = index; i < cnt-1; i++) {
				list[i] = temp[i+1];
			}
			temp = null;
		}
		cnt--;
		return del_st;
	}
	int check_id(Student st) {
		int check = -1;
		for (int i = 0; i < cnt; i++) {
			if(list[i].id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
	}
	void print_student() {
		for (int i = 0; i < cnt; i++) {
			list[i].print_data();
		}
	}
	String out_data() {
		String data ="";
		if(cnt == 0) {
			return data = "";
		}
		data += cnt;
		data += "\n";
		for (int i = 0; i < cnt; i++) {
			data += list[i].id;
			data += "/";
			data += list[i].pw;
			if(cnt - 1 != i) {
				data += "\n";
			}
		}
		return data;
	}
	void sort_data() {
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				if(list[i].id.compareTo(list[j].id) > 0) {
					Student temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	void load_student(Student [] temp , int c) {
		cnt = c;
		list = temp;
	}
	
}

public class Ex04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		boolean run =true;
		
		while(run) {
			System.out.println("[1]가입");
			System.out.println("[2]탈퇴");
			System.out.println("[3]정렬");
			System.out.println("[4]출력");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			
			int sel = sc.nextInt();
			
			if(sel == 1) {
				Student temp = new Student();
				
				System.out.print("ID : ");
				temp.id = sc.next();
				
				int check = manager.check_id(temp);
				
				if(check == -1) {
					System.out.print("PW : ");
					temp.pw = sc.next();
					
					manager.add_student(temp);
					System.out.println(temp.id + " 가입완료");
				}else {
					System.out.println("ID 중복");
				}
				
			}
			else if(sel == 2) {
				manager.print_student();
				Student temp = new Student();
				System.out.print("ID :");
				temp.id = sc.next();
				
				int check = manager.check_id(temp);
				if(check == -1) {
					System.out.println("해당 ID는 존재하지 않습니다.");
				}else {
					Student del_st = manager.remove_student(check);
					System.out.println(del_st.id + " 탈퇴완료");
				}
				
			}
			
			else if(sel == 3) {
				manager.sort_data();
				manager.print_student();
			}
			else if(sel == 4) {
				manager.print_student();
			}
			else if(sel == 5) {
				if(manager.cnt == 0)return;
				try {
					FileWriter fw = new FileWriter("student_manager.txt");
					String data = manager.out_data();
					if(!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(sel == 6) {
				
				try {
					File file = new File("student_manager.txt");
					if(file != null) {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = br.readLine();
						int cnt = Integer.parseInt(line);
						
						Student [] temp = new Student[cnt];
						for (int i = 0; i < cnt; i++) {
							temp[i] = new Student();
							line = br.readLine();
							String value[] = line.split("/");
							
							temp[i].id = value[0];
							temp[i].pw = value[1];
						}
						fr.close();
						br.close();
						manager.load_student(temp, cnt);
					}
					manager.print_student();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}

}
