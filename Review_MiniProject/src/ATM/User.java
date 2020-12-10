package ATM;

public class User {

	//아이디 / 비밀번호 / 계좌 / 계좌 수
	
	String id = "";
	String pw = "";
	
	Account[] acc = new Account[UserManager.ACC_MAX_CNT];
	int accCnt = 0;
}
