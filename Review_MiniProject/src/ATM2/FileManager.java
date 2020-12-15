package ATM2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	
	static FileManager instance = new FileManager();
	
	String fileName = "AtmData.txt";
	
	boolean loadData() {
		boolean rs = false;
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		if(file.exists()) {
			rs = true;
			
			
			UserManager.instance.userList = null;
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String strCnt = br.readLine();
				int cnt = Integer.parseInt(strCnt);
				
				UserManager.instance.userList = new User[cnt];
				UserManager.instance.userCnt = 0;
				
				while(true) {
					
					String line = br.readLine();
					if(line == null) break;
					
					String info[] = line.split("/");
					int size = info.length;
					
					User user = null;
					
					if(size == 3) {
						user = new User(info[0],info[1],null,0);
					}else {
						String id = info[0];
						String pw = info[1];
						int accCnt = Integer.parseInt(info[2]);
						Account accList[] = new Account[accCnt];
						int j = 3;
						for (int i = 0; i < accCnt; i++) {
							accList[i] = new Account();
							accList[i].num = info[j];
							accList[i].money = Integer.parseInt(info[j+1]);
							j = j + 2;
						}
						user = new User(id,pw,accList,accCnt);
					}
					UserManager.instance.userList[UserManager.instance.userCnt] = user;
					
					UserManager.instance.userCnt = UserManager.instance.userCnt + 1;
				}
				System.out.println("파일을 로드했습니다.");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(fr != null) { try {fr.close();} catch (IOException e) {}}
				if(br != null) { try {br.close();} catch (IOException e) {}}
			}
			
		}
		return rs;
	}
	
	void saveData() {
		UserManager userManager = UserManager.instance;
		
		if(userManager.userCnt == 0) return;
		
		String data = "";
		data += userManager.userCnt;
		data += "\n";
		
		for (int i = 0; i < userManager.userCnt; i++) {
			User user = userManager.userList[i];
			
			data += user.id;	data += "/";
			data += user.pw;	data += "/";
			data += user.accCnt;
			if(user.accCnt > 0) {
				data += "/";
				
				for (int j = 0; j < user.accCnt; j++) {
					Account acc = user.accList[j];
					
					data += acc.num;
					data += "/";
					data += acc.money;
					
					if( j != user.accCnt -1) {
						data +="/";
					}
				}
			}
			
			if(i != userManager.userCnt -1) {
				data += "\n";
			}
		}
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			System.out.println("파일을 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw != null) { try {fw.close();} catch(IOException e) {}}
		}
	}
	
	
}
