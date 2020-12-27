package ATM2_re;

public class User {
	String id;
	String pw;
	
	Account[] accList;
	int accCnt;
	
	
	public User(){}
	public User(String id, String pw){
		this.id = id;
		this.pw = pw;
		
	}
	
	public User(String id, String pw, Account[] accList, int accCnt) {
		this.id = id;
		this.pw = pw;
		this.accList = accList;
		this.accCnt = accCnt;
	}
	void printUser() {
		
		if(accCnt ==0) {
			System.out.println(id+ "\t"+pw +"\t"+"계좌를 개설해 주세요");
		}else {
			System.out.print(id+ "\t"+pw +"\t");
			for (int i = 0; i < accCnt; i++) {
				System.out.print(accList[i].num + "/" + accList[i].money);
				
				if(i != accCnt -1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
}
