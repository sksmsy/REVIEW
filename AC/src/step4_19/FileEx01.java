package step4_19;

import java.io.FileWriter;

public class FileEx01 {

	public static void main(String[] args) {

		

		FileWriter fw = null;
		
		try {
			fw = new FileWriter("abcd.txt");
			fw.write("abcd");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
