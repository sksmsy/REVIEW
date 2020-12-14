package SHOP;

import java.util.Scanner;
import java.util.Vector;

public class Item {

	String name;
	int price;
	String category;
	
	Item(String na, int pr, String cate){
		name = na;
		price = pr;
		category = cate;
	}
	
	void print() {
		System.out.println("["+name +"]"+"["+price+"]"+"["+category+"]");
	}
	
}

class Cart{
	String userId;
	String itemName;
	
	void print() {
		System.out.println("["+userId+"]"+"아이템 : " + itemName);
	}
	
	void printMyCart() {
		System.out.println("아이템 : " + itemName );
	}
}

class ItemManager{
	Scanner sc = new Scanner(System.in);
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>();
	Vector<Cart> jangList = new Vector<Cart>();
	
	ItemManager(){
		init();
	}
	
	void init() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료");
		Item temp = new Item("새우깡",1000,category.get(0));
		itemList.add(temp);
		temp = new Item("참치",10000,category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
		itemList.add(temp);
	}
	
	void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).print();
		}
	}
	
	void printJang(User u) {
		for (int i = 0; i < jangList.size(); i++) {
			if(u.id.equals(jangList.get(i).userId)) {
				System.out.print("["+i+"]");
				jangList.get(i).printMyCart();
			}
		}
	}
	void printCategory(){
		for (int i = 0; i < category.size(); i++) {
			System.out.println("["+i+"]" + category.get(i));
		}
	}
	
	void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + i + "]");
			itemList.get(i).print();
		}
	}
	
	void printItemList(int caID) {
		int n = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if(category.get(caID).equals(itemList.get(i).category)) {
				System.out.print("["+n+"]");
				itemList.get(i).print();
				n+=1;
			}
		}
	}
	
	void addItem() {
		System.out.println("[아이템추가] 아이템이름 : ");
		String name = sc.next();
		System.out.println("[아이템추가] 가격 : " );
		int price = sc.nextInt();
		
		printCategory();
		System.out.println("[아이템추가] 카테고리 입력 : ");
		int sel = sc.nextInt();
		
		Item temp = new Item(name,price,category.get(sel));
		itemList.add(temp);
	}
	
	void removeItem() {
		printItemList();
		System.out.println("[아이템삭제] 삭제할 아이템 번호 : ");
		int sel = sc.nextInt();
		
		itemList.remove(sel);
	}
	
	
	void addCategroy() {
		System.out.println("[카테고리 추가] 추가 할 카테고리 이름 : ");
		String name = sc.next();
		
		category.add(name);
	}
	
	void removeCategory() {
		printCategory();
		System.out.println("삭제할 카테고리 번호 : ");
		int sel = sc.nextInt();
		
		category.remove(sel);
	}
	
	void addCart(String usId, int caId, int itemId) {
		int n = 0;
		Cart temp = new Cart();
		
		temp.userId = usId;
		for (int i = 0; i < itemList.size(); i++) {
			if(category.get(caId).equals(itemList.get(i).category)) {
				if(itemId==n) {
					temp.itemName = itemList.get(i).name;
				}
				n+=1;
			}
		}
		jangList.add(temp);
	}
	
	void removeCart(User u) {
		printJang(u);
		
		System.out.println("삭제할 아이템 번호 : ");
		int sel = sc.nextInt();
		
		jangList.remove(sel);
		
	}

}