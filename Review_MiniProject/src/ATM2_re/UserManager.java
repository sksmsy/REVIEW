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
		
		FileManager.instance.saveData();
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
		FileManager.instance.saveData();
	}
	
	void leaveUser() {		
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
		ATM.log = -1;
		FileManager.instance.saveData();
	}
	
	int checkAcc(String num) {
		int check = -1;
		
		for (int i = 0; i < userList.length; i++) {
			for (int j = 0; j < userList[i].accCnt; j++) {
				if(num.equals(userList[i].accList[j].num)) {
					check = j;
				}
			}
		}
		return check;
	}
	
	void createAcc() {

		User loginUser = userList[ATM.log];
		int accCnt = loginUser.accCnt;
		
		if(accCnt == 0) {
			loginUser.accList = new Account[accCnt +1];
		}else if(accCnt > 0) {
			Account temp[]= loginUser.accList;
			loginUser.accList = new Account[accCnt + 1];
			
			for (int i = 0; i < temp.length; i++) {
				loginUser.accList[i] = temp[i];
			}
			temp= null;
		}
		loginUser.accList[accCnt] = new Account();
		
		while(true) {
			int r =ATM.ran.nextInt(99999)+10000;
			int check = checkAcc(r+"");
			
			if(check == -1) {
				loginUser.accList[accCnt].num = r+"";
				loginUser.accList[accCnt].money = 1000;
				accCnt += 1;
				loginUser.accCnt = accCnt;
				System.out.println("계좌가 생성되었습니다.");
				break;
			}
		}
		FileManager.instance.saveData();
	}
	
	void removeAcc() {
		
		showAccList();
		System.out.println("[계좌삭제] 삭제하실 계좌를 선택하세요.");
		int sel=ATM.sc.nextInt()-1;
	
		User loginUser = userList[ATM.log];
		int accCnt = userList[ATM.log].accCnt;
		
		if(accCnt == 1) {
			loginUser.accList = null;
		}else if (accCnt > 1) {
			Account temp[] = userList[ATM.log].accList;
			
			loginUser.accList = new Account[accCnt -1];
			
			int j = 0;
			for (int i = 0; i < temp.length; i++) {
				if(i!= sel) {
					loginUser.accList[j] = temp[i];
					j += 1;
				}
			}
			temp = null;
		}
		System.out.println("계좌가 삭제되었습니다.");
		accCnt -= 1;
		loginUser.accCnt = accCnt;
		FileManager.instance.saveData();
	}
	
	
	void showAccList() {
		int accCnt = userList[ATM.log].accCnt;
		
		if(accCnt == 0) {
			System.out.println("보유하고 계시는 계좌가 없습니다.");
			System.out.println("계좌를 생성해 주세요.");
		}else if(accCnt > 0) {
			System.out.println(userList[ATM.log].id + " / " + userList[ATM.log].pw);
			System.out.println("보유 계좌 수 : " + userList[ATM.log].accCnt);
			for (int i = 0; i < userList[ATM.log].accCnt; i++) {
				System.out.println("["+(i+1)+"]"+userList[ATM.log].accList[i].num + " : " + userList[ATM.log].accList[i].money);
			}
		}
		System.out.println("============================");
	}
	
	void deposit() {
		showAccList();
		if(userList[ATM.log].accCnt > 0) {
			
			System.out.println("[입금] 입금하실 계좌를 선택하세요.");
			int sel = ATM.sc.nextInt()-1;
			
			System.out.println("[입금] 금액 : ");
			int money = ATM.sc.nextInt();
			
			userList[ATM.log].accList[sel].money += money;
			
			System.out.println(money+"원 입금이 완료되었습니다.");
		}
		FileManager.instance.saveData();
	}

	void withdraw() {
		showAccList();
		
		if(userList[ATM.log].accCnt > 0 ) {
			System.out.println("[출금] 출금하실 계좌를 선택하세요.");
			int sel = ATM.sc.nextInt()-1;
			
			System.out.println("[출금] 금액 : ");
			int money = ATM.sc.nextInt();
			
			if(userList[ATM.log].accList[sel].money < money) {
				System.out.println("계좌 잔액이 부족합니다.");
			}else {
				userList[ATM.log].accList[sel].money -= money;
			}
		}
		FileManager.instance.saveData();
	}
	
	void transfer() {
		int accCnt = userList[ATM.log].accCnt;
		if(accCnt == -1) {
			System.out.println("보유하고 계시는 계좌가 없습니다.");
			System.out.println("계좌를 생성해 주세요.");
			return;
		}
		
		System.out.println("[이체] 입금하실 계좌번호를 입력하세요.");
		String num =ATM.sc.next();
		
		
		int accIdx = checkAcc(num);
		int userIdx = -1;
		for (int i = 0; i < userList.length; i++) {
			 for (int j = 0; j < userList[i].accCnt; j++) {
				if(num.equals(userList[i].accList[j].num)){
					userIdx = i;
				}
			}
		}
		
		if(accIdx == -1) {
			System.out.println("계좌번호를 확인해주세요.");
			return;
		}
		
		showAccList();
		System.out.println("[이체] 출금계좌 선택 : ");
		int sel = ATM.sc.nextInt()-1;

		System.out.println("[이체] 입금하실 금액 : ");
		int money = ATM.sc.nextInt();
		
		
		if(money > userList[ATM.log].accList[sel].money) {
			System.out.println("출금계좌 잔액이 부족합니다.");
			return;
		}
		
		userList[ATM.log].accList[sel].money -= money;
		userList[userIdx].accList[accIdx].money += money;
		System.out.println("이체가 완료되었습니다.");
		FileManager.instance.saveData();
	}
}
