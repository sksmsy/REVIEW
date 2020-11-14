package step4_19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileEx02 {

	public static void main(String[] args) {
	
		String fileName = "fileTest.txt";
		
		// 기존에 있던 파일을 찾아서 -> file 변수에 담음
		File file = new File(fileName);
		/*
		 * apple
		 * blue
		 */	
		
		FileReader fr = null;
		BufferedReader br = null;
		
		if(file.exists()) {    // file 존재유무를 확인 -> true / false
			try {
				fr = new FileReader(file);   // 힙메모리에서 사용할 준비(메모리 할당)
				br = new BufferedReader(fr); // 힙메모리에서 사용할 준비(메모리 할당)
				
				String data = "";
				
				// .닷 은 link(연결)의 의미
				data = br.readLine();		// apple	
				System.out.println(data);
//				
//				String data1 = br.readLine();	// blue
//				System.out.println(data1);
//				
//				String data3 = br.readLine();	// null
//				System.out.println(data3);
				
				fr.close();
				br.close();
				
			} catch(Exception e ) {
				e.printStackTrace();
			}
		}

	}

}
