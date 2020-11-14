package step8;

import java.util.ArrayList;

class Tv{
	String name;
	String brand;
	int price;
	
	Tv(String name, String brand, int price){
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
}
public class Ex05 {
	public static void main(String[] args) {
		
		
		ArrayList<Tv> list = new ArrayList<>();
		
		Tv temp = new Tv("TV","삼성",1000);
		list.add(temp);
		
		temp = new Tv("시그니처TV","LG",2000);
		list.add(temp);
		
		temp = new Tv("스마트TV","Apple",3000);
		list.add(temp);
		
		
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i).brand + list.get(i).name);
		}
		
	}
}
