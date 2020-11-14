package step7;

import java.util.Random;
import java.util.Scanner;

class Word{
	Random ran = new Random();
	String word;
	int ranPos;
	void setRandomWordPos(String sample) {
		
		word = sample;
		int r = ran.nextInt(word.length());
		ranPos = r;
		
	}
	
	void printWord() {
		for (int i = 0; i < word.length(); i++) {
			if(i == ranPos) {
				System.out.print("*");
			}else {
				System.out.print(word.charAt(i));
			}
		}
		System.out.println();
	}
}

class WordSample{
	Random ran = new Random();
	String [] wordSampleList= {"java","jsp","python","android","spring"};
	boolean [] checkList = new boolean[wordSampleList.length];
	int cnt = wordSampleList.length;
	String getRandomWord() {
		int r = 0;
		while(true) {
			r = ran.nextInt(wordSampleList.length);
			if(checkList[r] == false) {
				checkList[r] = true;
				cnt -= 1;
				break;
			}
		}
		return wordSampleList[r];
	}
}


public class Ex10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		WordSample wSample = new WordSample();
		Word[] wordList = new Word[wSample.wordSampleList.length];
		
		for (int i = 0; i < wordList.length; i++) {
			wordList[i] = new Word();
		}
		
		boolean run = true;
		int index = 0;
		
		long beforeTime = System.currentTimeMillis();
		while(run) {
			wordList[index].setRandomWordPos(wSample.getRandomWord());
			while(true) {
				wordList[index].printWord();
				System.out.println("단어 >>> ");
				String inputWord = sc.next();
				if(inputWord.equals(wordList[index].word)){
					System.out.println("정답");
					break;
				}else {
					System.out.println("땡");
				}
			}
			if(wSample.cnt == 0) {
				long afterTime = System.currentTimeMillis();
				double secDiffTime = (afterTime - beforeTime) / 1000.0;
				System.out.println("기록 : " + secDiffTime);
				System.out.println("종료");
				break;
			}
		}
		sc.close();
	}

}
