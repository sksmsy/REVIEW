package step8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

class Student{
	String id = "";
	String pw = "";
	
	void set_data(String i, String p) {
		id = i; pw = p;
	}
	
	void print_data() {
		System.out.println("id : " + id + " / pw : " + pw);
	}
}

class Manager{
	Vector<Student> vec = new Vector<>();
	
	void add_student(Student st) {
		vec.add(st);
	}
	
	Student remove_student(int idx) {
		Student del_st = vec.get(idx);
		vec.remove(idx);
		return del_st;
	}
	
	int check_id(Student st) {
		int check = -1;
		for (int i = 0; i < vec.size(); i++) {
			if(vec.get(i).id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	void print_student() {
		for (int i = 0; i < vec.size(); i++) {
			vec.get(i).print_data();
		}
	}
	
	String out_data() {
		String data = "";
		int cnt = vec.size();
		if(cnt == 0) {
			return data;
		}
		data += cnt;
		data +="\n";
		for (int i = 0; i < cnt; i++) {
			data += vec.get(i).id;
			data += "/";
			data += vec.get(i).pw;
			data += "\n";
		}
		data = data.substring(0, data.length()-1);
		return data;
	}
	
	void sort_data() {
	    
		for (int i = 0; i < vec.size(); i++) {
			for (int j = 0; j < vec.size(); j++) {
				if(vec.get(i).id.compareTo(vec.get(j).id) > 0) {
					
					Student temp = vec.get(i);
					Student temp2 = vec.get(j);
					vec.set(j, temp);
					vec.set(i, temp2);
				}
			}
		}

	}
	
	void load_student(Vector<Student>temp) {
		vec = temp;
	}
	int get_size() {
		return vec.size();
	}
	
}
public class Ex07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		boolean run = true;
		
		while(run) {
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드");
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
					System.out.println(temp.id + "가입 완료");
				}else {
					System.out.println("ID중복");
				}
			}
			else if(sel == 2) {
				Student temp = new Student();
				manager.print_student();
				
				System.out.print("삭제할 ID : ");
				temp.id = sc.next();
				
				int check = manager.check_id(temp);
				
				if(check > -1) {
					manager.remove_student(check);
					System.out.println(temp.id+"삭제");
				}else {
					System.out.println("없는ID");
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
				if(manager.get_size() == 0)return;
				
				try {
					FileWriter fw = new FileWriter("Vector_StManager.txt");
					String data = manager.out_data();
					fw.write(data);
					fw.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(sel == 6) {
				
				File file = new File("Vector_StManager.txt");
				
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						String line = br.readLine();
						int cnt = Integer.parseInt(line);
						Vector<Student> vec = new Vector<Student>();
						for (int i = 0; i < cnt; i++) {
							Student temp = new Student();
							line = br.readLine();
							String value[] = line.split("/");
							
							temp.id = value[0];
							temp.pw = value[1];
							vec.add(temp);
						}
						fr.close();
						br.close();
						manager.load_student(vec);
						
						manager.print_student();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	}
}
