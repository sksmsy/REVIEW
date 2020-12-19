package ATM2_re;

public class UserManager {
	
	static UserManager instance = new UserManager();
	
	User[] userList;
	int userCnt;
	
	
	void printAllUser(){
		for (int i = 0; i < userCnt; i++) {
			userList[i].printUser();
		}
		
		System.out.println("===================================");
	}
	void setDummy() {
		userCnt = 5;
		userList = new User[userCnt];
		for (int i = 0; i < userList.length; i++) {
			userList[i] = new User();
		}
		
		
		String dummy[] = {"a","b","c","d","e","f","g","h","i"};
		for (int i = 0; i < userCnt; i++) {
			String userId = "";
			for (int j = 0; j < 4; j++) {
				int r = ATM.ran.nextInt(dummy.length);
				
				userId += dummy[r];
			}
			int r = ATM.ran.nextInt(9999)+1000;
			
			userList[i].id = userId;
			userList[i].pw = r+"";
		}
	}
	
	int checkId(String id) {
		int check = -1;
		
		for (int i = 0; i < userCnt; i++) {
			if(id.equals(userList[i].id)) {
				check = i;
			}
		}
		return check;
	}
	
	void joinUser() {
		System.out.println("ID >> ");
		String id = ATM.sc.next();
		
		int check = checkId(id);
		if(check > -1) {
			System.out.println("ID가 중복됩니다.");
			return;
		}
		
		System.out.println("PW >> ");
		String pw = ATM.sc.next();
		
		if(userCnt == 0) {
			userList = new User[1];
			userList[0] = new User(id,pw);
		}else if(userCnt > 0) {
			
			User temp[] = userList;
			
			userList = new User[userCnt+1];
			for (int i = 0; i < temp.length; i++) {
				userList[i] = temp[i];
			}
			temp = null;
			
			
			userList[userCnt] = new User(id,pw);
		}
		userCnt += 1;
		
		System.out.println("회원가입 완료");
	}
	
	void leaveUser() {
		if(ATM.log == -1) {
			System.out.println("로그인이 필요합니다.");
			return;
		}
		
		if(userCnt == 1) {
			userList = null;
		}else {
			User temp[] = userList;
			
			userList = new User[userCnt-1];
			int j= 0;
			for (int i = 0; i < temp.length; i++) {
				if(i != ATM.log) {
					userList[j] = temp[i];
					j +=1;
				}
			}
			
			temp = null;
		}
		System.out.println("탈퇴 완료");
		userCnt -=1;
	}
	
	void createAcc() {
		
	}
}
