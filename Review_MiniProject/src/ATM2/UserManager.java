package ATM2;

public class UserManager {
	static UserManager instance = new UserManager();
	
	
	User[] userList;
	int userCnt;
	
	
	void printAllUserInfo() {
		System.out.println("아이디\t패스워드\t계좌정보");
		for (int i = 0; i < userCnt; i++) {
			userList[i].printUserInfo();
		}
		System.out.println("----------------------------");
	}
	
	void setDummy() {
		
		userCnt = 5;
		userList = new User[userCnt];
		for (int i = 0; i < userCnt; i++) {
			userList[i] = new User();
		}
		String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
		String[] b = {"l", "b", "c", "m", "e", "f", "g", "n", "i", "p", "k"};
		String[] c = {"s", "t", "u", "w", "v", "o", "x", "n", "q", "p", "r"};
		
		for (int i = 0; i < userCnt; i++) {
			String id = "";
			int rNum = ATM.ran.nextInt(a.length);
			id += a[rNum];
			rNum = ATM.ran.nextInt(b.length);
			id += b[rNum];
			rNum = ATM.ran.nextInt(c.length);
			id += c[rNum];
			
			userList[i].id = id;
		}
		
		for (int i = 0; i < userCnt; i++) {
			String pw = "";
			
			int rNum = ATM.ran.nextInt(9000)+1000;
			
			pw = rNum+"";
			
			userList[i].pw = pw;
		}
		
		printAllUserInfo();
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
		System.out.println("[가입] ID : ");
		String id = ATM.sc.next();
		
		int check = checkId(id);
		
		if(check == -1) {
			System.out.println("ID가 중복됩니다.");
			return;
		}
		
		System.out.println("[가입] PW : ");
		String pw = ATM.sc.next();
		
	
		
		if(userCnt == 0) {
			userList = new User[1];
			userList[0] = new User(id,pw);
		}else if(userCnt > 0) {
			
			User[] temp = userList;
			
			userList = new User[userCnt + 1];
			for (int i = 0; i < userCnt; i++) {
				userList[i] = temp[i];
			}
			
			userList[userCnt] = new User(id,pw);
			
			temp = null;
		}
		
		userCnt = userCnt + 1;
		
		System.out.println("회원가입 완료");
		
		FileManager.instance.saveData();
		
		printAllUserInfo();
		
		FileManager.instance.saveData();
	}
	
	void leaveUser() {
		if(userCnt == 1) {
			userList = null;
		}else if(userCnt > 1) {
			User[] temp = userList;
			
			userList = new User[userCnt -1];
			int j = 0;
			for (int i = 0; i < userCnt; i++) {
				if(i != ATM.log) {
					userList[j] = temp[i];
					j = j+1;
				}
			}
		}
		userCnt = userCnt -1;
		
		ATM.log = -1;
		System.out.println("탈퇴완료");
		
		FileManager.instance.saveData();
	}
	
	void createAccount() {
		User loginUser = userList[ATM.log];
		int accCnt = loginUser.accCnt;
		
		if(accCnt == 3) {
			System.out.println("더 이상 계좌를 생성할 수 없습니다.");
			return;
		}
		
		if(accCnt == 0) {
			loginUser.accList = new Account[accCnt +1];
		}else if(accCnt > 0) {
			Account[] temp = loginUser.accList;
			
			loginUser.accList = new Account[accCnt+1];
			
			 for (int i = 0; i < accCnt; i++) {
				loginUser.accList[i] = temp[i];
			}
			 temp = null;
		}
		loginUser.accList[accCnt] = new Account();
		
		int rNum = ATM.ran.nextInt(10000)+1;
		loginUser.accList[accCnt].num = rNum + "";
		loginUser.accList[accCnt].money = 1000;
		
		accCnt = accCnt+1;
		loginUser.accCnt = accCnt;
		System.out.println("계좌가 생성되었습니다.");
		
		FileManager.instance.saveData();
	}
	
	int showAccList(String msg) {
		int loginAccIndex = -1;
		
		User temp = userList[ATM.log];
		int accCnt = temp.accCnt;
		
		if(accCnt > 0) {
			for (int i = 0; i < accCnt; i++) {
				System.out.println("[" + (i+1) + "]" + temp.accList[i].num);
			}
			
			System.out.println("[" + msg + "]계좌를 선택하세요 : ");
			loginAccIndex = ATM.sc.nextInt();
			loginAccIndex = loginAccIndex -1;
		}
		
		return loginAccIndex;
	}
	
	void income() {
		int loginAccIndex = showAccList("입금");
		if(loginAccIndex == -1) {
			System.out.println("계좌를 먼저 생성해 주세요");
			return;
		}
		
		System.out.println("[입금]금액을 입력하세요 : ");
		int money = ATM.sc.nextInt();
		
		userList[ATM.log].accList[loginAccIndex].money += money;
		System.out.println("입금이 완료되었습니다.");
		
		FileManager.instance.saveData();
	}
	
	void outcome() {
		int loginAccIndex = showAccList("출금");
		if(loginAccIndex == -1) {
			System.out.println("계좌를 먼저 생성해 주세요");
			return;
		}
		
		System.out.println("[출금]금액을 입력하세요 : ");
		int money = ATM.sc.nextInt();
		
		if(userList[ATM.log].accList[loginAccIndex].money < money) {
			System.out.println("계좌 잔액이 부족합니다.");
			return;
		}
		
		userList[ATM.log].accList[loginAccIndex].money -= money;
		System.out.println("출금이 완료되었습니다.");
			
		FileManager.instance.saveData();
	}
	
	int checkAcc(String transAccount) {
		int check = -1;
		
		for (int i = 0; i < userList.length; i++) {
			if(userList[i].accList != null) {
				for (int j = 0; j < userList[i].accCnt; j++) {
					if(transAccount.equals(userList[i].accList[i].num)) {
						check = i;
					}
				}
			}
		}
		return check;
	}
	
	int getAcc(int transUserIndex, String transAccount) {
		int accIndex = 0;
		
		for (int i = 0; i < userList[transUserIndex].accCnt; i++) {
			if(transAccount.equals(userList[transUserIndex].accList[i].num)) {
				accIndex = i;
			}
		}
		return accIndex;
	}
	
	void transfer() {
		int loginAccIndex = showAccList("이체");
		
		if(loginAccIndex == -1) {
			System.out.println("계좌를 먼저 생성해주세요");
			return;
		}
		
		System.out.print("계좌 번호를 입력하세요 : ");
		String num =ATM.sc.next();
		
		int transUserIndex = checkAcc(num);
		if(transUserIndex == -1) {
			System.out.println("계좌번호를 확인해 주세요");
			return;
		}
		
		int transAccIndex = getAcc(transUserIndex, num);
		
		System.out.println("[이체]금액을 입력하세요 : ");
		int money = ATM.sc.nextInt();
		
		if(money > userList[ATM.log].accList[loginAccIndex].money) {
			System.out.println("계좌 잔액이 부족합니다.");
			return;
		}
		
		userList[ATM.log].accList[loginAccIndex].money -= money;
		userList[transUserIndex].accList[transAccIndex].money += money;
		System.out.println("이체가 완료되었습니다.");
		
		FileManager.instance.saveData();
	}
	
	void lookupAcc() {
		userList[ATM.log].printUserInfo();
	}
	
	void deleteAcc() {
		int loginAccIndex = showAccList("삭제");
		if(loginAccIndex == -1) {
			System.out.println("계좌를 먼저 생성해주세요");
			return;
		}
		
		User temp = userList[ATM.log];
		int accCnt = temp.accCnt;
		
		if(accCnt == 1) {
			temp.accList = null;
			
		}else if(accCnt > 1) {
			Account[] acc = temp.accList;
			
			temp.accList = new Account[accCnt-1];
			int j = 0;
			for (int i = 0; i < accCnt; i++) {
				if(i != loginAccIndex) {
					temp.accList[j] = acc[i];
					j = j+1;
				}
			}
			acc = null;
		}
		accCnt = accCnt -1;
		
		temp.accCnt = accCnt;
		System.out.println("계좌삭제 완료");
		
		FileManager.instance.saveData();
	}
}
