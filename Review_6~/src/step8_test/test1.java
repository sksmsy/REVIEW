package step8_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

class Stu{
	String id ="";
	String pw ="";
	
	void set_data(String a, String b){
		id = a;
		pw = b;
	}
	
	void print_data() {
		System.out.println(id + " : "+ pw);
	}
}


class Manager{
	Vector<Stu> list = new Vector<Stu>();
	
	void add_student(Stu st) {
		
		list.add(st);
	}
	
	Stu remove_student(int index) {
		Stu del = list.get(index);
		list.remove(index);
		
		return del;
	}
	
	int check_id(Stu st) {
		int check = -1;
		for (int i = 0; i < list.size(); i++) {
			if(st.id.equals(list.get(i).id)) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	void sort_data() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(list.get(i).id.compareTo(list.get(j).id) > 0) {
				
					Stu temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp); 
				}
			}
		}
	}
	
	String out_data() {
		
		String data = "";
		
		int cnt = list.size();
		data += cnt;
		data += "\n";
		for (int i = 0; i < list.size(); i++) {
			data += list.get(i).id;
			data += "/";
			data += list.get(i).pw;
			data += "\n";
		}
		data = data.substring(0, data.length()-1);
		
		return data;
	}
	
	void load_data(Vector<Stu> temp) {
		list = temp;
	}
	
	void printAll(){
		for (int i = 0; i < list.size(); i++) {
			list.get(i).print_data();
		}
	}
	
	
}


public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Manager m = new Manager();
		
		
		while(true) {
			System.out.println("1.가입 2.탈퇴 3.출력 4.정렬 5.저장 6.로드");
			System.out.print(">>>");
			
			int sel = sc.nextInt();
			
			if(sel == 1) {
				Stu temp = new Stu();
				System.out.print("ID : ");
				temp.id = sc.next();
				
				int check = m.check_id(temp);
				
				if(check == -1) {
					System.out.print("PW : ");
					temp.pw = sc.next();
					
					m.add_student(temp);
				}else {
					System.out.println("ID 중복");
				}
			}
			else if(sel == 2) {
				Stu temp = new Stu();
				System.out.println("ID : ");
				temp.id = sc.next();
				
				int check = m.check_id(temp);
				
				if(check == -1) {
					System.out.println("해당 ID가 없습니다");
				}else {
					Stu del = m.remove_student(check);
					System.out.println(del.id+"님 탈퇴완료");
				}
				
			}else if(sel == 3) {
				m.printAll();
			}
			else if(sel == 4) {
				m.sort_data();
				m.printAll();
			}
			
			else if(sel == 5) {
				 try {
					 FileWriter fw = new FileWriter("s8test3.txt");
					 String data = m.out_data();
					 fw.write(data);
					 System.out.println("SAVE");
					 fw.close();
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(sel == 6) {
				File file = new File("s8test3.txt");
				
				if(file.exists()) {
					try {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String data = br.readLine();
						int cnt = Integer.parseInt(data);
						
						Vector<Stu> list = new Vector<Stu>();
						for (int i = 0; i < cnt; i++) {
							Stu temp = new Stu();
							data = br.readLine();
							String value[] = data.split("/");
							
							temp.id = value[0];
							temp.pw = value[1];
							list.add(temp);
						}
						fr.close();
						br.close();
						m.load_data(list);
						
						m.printAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
