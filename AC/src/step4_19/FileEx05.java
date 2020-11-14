package step4_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileEx05 {

	public static void main(String[] args) {

		
		String ids[] = null;
		String pws[] = null;
		int money[] = null;
		
		
		
		String fileName = "fileTest01.txt";
		
		File file = new File(fileName);
		
		int size = 3;

		if(file.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				
				String data = "";
				
				ids = new String[size];
				pws = new String[size];
				money = new int[size];
				
				for (int i = 0; i < 3; i++) {
					data = br.readLine();
					String temp[] = data.split("/");
					
					ids[i] = temp[0];
					pws[i] = temp[1];
					money[i] = Integer.parseInt(temp[2]);
					
				}
				
				for (int i = 0; i < money.length; i++) {
					System.out.println(ids[i] + "/" + pws[i] + "/" + money[i]);
				}
				
				fr.close();
				br.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
		
		
	
		
	}

}
