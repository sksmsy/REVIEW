package rpg_final;

import java.util.ArrayList;

public class Inventory {

	
	ArrayList<Item> itemList = new ArrayList<>();
	
	//인벤토리 메뉴 
	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤토리 메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = GameManager.sc.nextInt();
			if (sel == 0)
				break;
			if (sel == 1) {
				equipMenu();
			}
			if (sel == 2) {
				sellMenu();
			}
		}
	}
}
