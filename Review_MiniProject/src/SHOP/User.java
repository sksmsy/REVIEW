package SHOP;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class User {

	String id;
	int money;
	
	User(String id, int mo){
		this.id = id;
		money = mo;
	}
	
	void print() {
		System.out.println("[" + id + "]" + "금액 : " + money);
	}
}


class UserManager{
	
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	Vector<User> userList = new Vector<>();
	int userLog = -1;
	
	UserManager(){
		init();
	}
	
	
	void init(){
		String a[] = {"a","b","c","d","e"};
		String b[] = {"a","b","c","d","e"};
		String c[] = {"a","b","c","d","e"};
		
		for (int i = 0; i < 10; i++) {
			int r= ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r = ran.nextInt(c.length);
			name += c[r];
			
			User temp = new User(name, ran.nextInt(50000));
			userList.add(temp);
		}
	}
	
	void join() {
		System.out.println("[가입] ID : ");
		String id = sc.next();
		User temp = new User(id,0);
		
		userList.add(temp);
		System.out.println("회원가입 완료");
	}
	
	boolean logIn() {
		userLog = -1;
		System.out.println("[로그인] ID : ");
		String id = sc.next();
		
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				userLog = i;
				break;
			}
		}
		if(userLog == -1) {
			System.out.println("없는 ID 입니다.");
		}else {
			return true;
		}
		
		return false;
	}
	
	void addUser() {
		System.out.println("[유저추가] ID : ");
		String name = sc.next();
		System.out.println("[유저추가] 소지금액 : ");
		int money = sc.nextInt();
		
		User user = new User(name,money);
		userList.add(user);
		
		System.out.println("추가완료");
	}
	
	void removeUser() {
		
		printUser();
		
		System.out.println("[유저삭제] 삭제할 유저 ID : ");
		String id =sc.next();
		
		for (int i = 0; i < userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				userList.remove(i);
			}
		}
		System.out.println("삭제 완료");
	}
	void logOut() {
		if(userLog != -1) {
			System.out.println("로그아웃 되었습니다.");
		}
		userLog = -1;
	}
	
	void printUser() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.println("[" + i+"]");
			userList.get(i).print();
		}
	}
}
