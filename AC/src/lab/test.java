package lab;

import java.util.ArrayList;

class Acc{
	String name = "";
	int num;
	
	void set(String a, int b) {
		name = a;
		num = b;
	}
	void print() {
		System.out.println(name + " : " + num);
	}
}

public class test {

	public static void main(String[] args) {
		
		ArrayList<Acc> list;

		String abc[] = {"ab","bc","cd","df"};
		
		
		list = new ArrayList<Acc>();
		
		
		for (int i = 0; i < abc.length; i++) {
			Acc temp = new Acc();
			
			temp.name = abc[i];
			temp.num = i + 1;
			
			list.add(temp);
			
		}
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).print();
		}
		
		
	}
}
