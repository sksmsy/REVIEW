package step4_19;

import java.io.FileWriter;

public class FileEx04 {

	public static void main(String[] args) {
		//aaaa/1111/20000
		//bbbb/2222/30000
		//cccc/3333/40000
		
		String name[] = {"aaaa", "bbbb", "cccc"};
		String pw[] = {"1111", "2222", "3333"};
		int money[] = {20000,30000,40000};
		
		String fileName = "fileTest01.txt";
		
		String data = "";
		
		for (int i = 0; i < money.length; i++) {
			data += name[i];
			data += "/";
			data += pw[i];
			data +="/";
			data += String.valueOf(money[i]);
			data += "\n";
			
		}
		data = data.substring(0, data.length()-1);


		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
