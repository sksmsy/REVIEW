package ATM;

public class _Main {	
	public static void main(String[] args) {
		Bank.instance.name = "ATM";
		BankManager.instance.play();
	}
}
