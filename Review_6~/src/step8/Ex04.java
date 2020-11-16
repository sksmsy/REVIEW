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

public class Ex04 {
	public static void main(String[] args) {
		ArrayList<Tv> list = new ArrayList<>();
		
		
		Tv temp = new Tv("Tv", "LG", 1000000);
		list.add(temp);
		
		
		
		
	}
}
