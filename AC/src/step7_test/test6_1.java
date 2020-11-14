package step7_test;

import java.util.Random;

class Card{
	String shape;
	int num;
	
	void print() {
		System.out.println(shape + " : " + num);
	}
}

class CardPlayer{
	Card card1;
	Card card2;
	
}

public class test6_1 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		CardPlayer aaa = new CardPlayer();
		CardPlayer bbb = new CardPlayer();
		
		String shapeList[] = {"♥", "◆","♠","♣"};
		int size = 40;
		Card deck[] = new Card[size];
		
		
		for (int i = 0; i < size; i++) {
			deck[i] = new Card();
			deck[i].num = i % 10 + 1;
			deck[i].shape = shapeList[i%4];
		}
		
		for (int i = 0; i < 100; i++) {
			int r = ran.nextInt(size);
			
			Card temp = deck[0];
			deck[0] = deck[r];
			deck[r] = temp;
		}
		
		aaa.card1 = deck[0];
		aaa.card2 = deck[1];
		bbb.card1 = deck[2];
		bbb.card2 = deck[3];
			
		aaa.card1.print();
		aaa.card2.print();
		System.out.println("--------");
		bbb.card1.print();
		bbb.card2.print();
		
		
	}
}
//1635
//1648