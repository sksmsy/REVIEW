package step4_19;

import java.io.FileWriter;

public class Ex00 {
	public static void main(String[] args) {
		
		// 파일저장/로드
		for (int j = 0; j < 3; j++) {
			String title = j+"test.txt";
			
			FileWriter fw = null;
			String data = "abcedf";
		
			
			try {
				fw = new FileWriter(title);
				fw.write(data);
			
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}


	}

}
