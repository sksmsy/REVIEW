package step7_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Student{
	String id;
	String pw;
	
	void set_data(String a, String b) {
		this.id = a; this.pw = b;
	}
	
	void print_data() {
		System.out.println(id+" : "+pw);
	}
}

class Manager{
	int cnt = 0;
	
	Student list[] = null;
	
	void add_student(Student s) {
		if(cnt == 0) {
			list = new Student[cnt + 1];
		}else {
			Student temp[] = list;
			list = new Student[cnt+ 1];
			
			for (int i = 0; i < temp.length; i++) {
				list[i] = temp[i];
			}
			temp = null;
			
		}
		list[cnt] = s;
		cnt ++;
		
	}
	
	Student remove_student(int idx) {
		Student del_st = list[idx];
		if(cnt == 1) {
			list = null;
		}else if(cnt > 1) {
			Student temp [] = list;
			list = new Student[cnt-1];
			
			for (int i = 0; i < idx; i++) {
				list[i] = temp[i];
			}
			
			for (int i = idx; i < cnt-1; i++) {
				list[i] = temp[i+1];
			}
			temp = null;
		}
		cnt --;
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
	
	void print_list() {
		for (int i = 0; i < cnt; i++) {
			list[i].print_data();
		}
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
	String out_data() {
		String data = "";
		if(cnt == 0) {
			return data;
		}
		data += cnt;
		data += "\n";
		for (int i = 0; i < cnt; i++) {
			data+= list[i].id;
			data+= "/";
			data+= list[i].pw;
			data+= "\n";
		}
		data = data.substring(0, data.length()-1);
		
		return data;
	}
	
	void load_student(Student [] temp , int c) {
		cnt =c;
		list = temp;
	}
}

public class test7 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
	
		Manager m = new Manager();
		
		while(true) {
			
			
			System.out.println("1.가입");
			System.out.println("2.탈퇴");
			System.out.println("3.정렬");
			System.out.println("4.출력");
			System.out.println("5.저장");
			System.out.println("6.로드");
			
			System.out.print(">>>");
			int sel = sc.nextInt();
			
			if(sel ==1 ) {
				Student temp = new Student();
				System.out.print("Id : ");
				temp.id = sc.next();
				
				int check = m.check_id(temp);
				
				if(check == -1) {
					System.out.print("PW : ");
					temp.pw = sc.next();
					m.add_student(temp);
					
					System.out.println(temp.id + " : " + temp.pw +"가입완료");
				}else {
					System.out.println("ID 중복");
				}
				
				
			}
			else if(sel == 2) {
				m.print_list();
				Student temp = new Student();
				System.out.println("ID : ");
				temp.id = sc.next();
				int check =m.check_id(temp);
				
				if(check == -1) {
					System.out.println("없는ID");
				}else {
					Student del_st = m.remove_student(check);
					System.out.println(del_st.id+"탈퇴완료");
				}
			}
			else if(sel == 3) {
				m.sort_data();
				m.print_list();
			}
			
			else if(sel == 4) {
				m.print_list();
			}
			
			else if(sel == 5) {
				if(m.cnt == 0) return;
				
				try {
					FileWriter fw = new FileWriter("student_manager.txt");
					String data = m.out_data();
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
					if(file.exists()) {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						
						String line = br.readLine();
						int cnt = Integer.parseInt(line);
						
						Student temp [] = new Student[cnt];
						for (int i = 0; i < temp.length; i++) {
							temp[i] = new Student();
							line = br.readLine();
							String value[] = line.split("/");
							temp[i].id = value[0];
							temp[i].pw = value[1];
						}
						fr.close();
						br.close();
						m.load_student(temp, cnt);
					}
					m.print_list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		}
		
		
		
	}
}
