package step4_19;

import java.io.FileWriter;

public class FileEx03 {

	public static void main(String[] args) {

		String name[] = {"가나다","라마바","사아자"};
		int age[] = {20, 30, 40};
		
		String fileName ="fileTest.txt";
		String data = "";
		
		for (int i = 0; i < age.length; i++) {
			data += name[i];
			data += "/";
			data += String.valueOf(age[i]);
			if(i != age.length-1) {
				data += ",";
			}
		}
		
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
