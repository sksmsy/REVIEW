package ATM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	static FileManager instance = new FileManager();
	
	String fileName = "ATM.txt";
	String data = "";
	
	void setData() {
		int cnt = UserManager.instance.userCnt;
		data += cnt;
		data += "\n";
		
		for (int i = 0; i < cnt; i++) {
			data += UserManager.instance.user[i].id;
			data += "\n";
			data += UserManager.instance.user[i].pw;
			data += "\n";
			data += UserManager.instance.user[i].accCnt;
			data += "\n";
			
			if(UserManager.instance.user[i].accCnt == 0) {
				data += "0\n";
			}else {
				for (int j = 0; j < UserManager.instance.user[i].accCnt; j++) {
					data += UserManager.instance.user[i].acc[j].num;
					data += "/";
					data += UserManager.instance.user[i].acc[j].money;
					if(j != UserManager.instance.user[i].accCnt -1) {
						data += ",";
					}
				}
			}
			data += "\n";
		}
	}
	
	void save() {
		setData();
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fw != null) { try {fw.close();} catch(IOException e) {}}
		}
		
	
	}
	
	void load() {
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			if(file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				
				while(true) {
					String line = br.readLine();
					
					if(line == null) {
						break;
					}
					data += line;
					data += "\n";
				}
				
				
				String temp[] = data.split("\n");
				UserManager.instance.userCnt = Integer.parseInt(temp[0]); 
				UserManager.instance.user = new User[UserManager.instance.userCnt];
				for (int i = 0; i < UserManager.instance.userCnt; i++) {
					UserManager.instance.user[i] = new User();
				}
				
				int j = 0;
				for (int i = 1; i < temp.length; i+=4) {
					String id = temp[i];
					String pw = temp[i+1];
					int accCnt = Integer.parseInt(temp[i+2]);
					
					String accInfo = temp[i+3];
					
					if(accCnt == 1) {
						String temp2[] = accInfo.split("/");
						int acc = Integer.parseInt(temp2[0]);
						int money = Integer.parseInt(temp2[1]);
						
						UserManager.instance.user[j].acc[0] = new Account();
						UserManager.instance.user[j].acc[0].num = acc;
						UserManager.instance.user[j].acc[0].money = money;
						
					}
					if(accCnt > 1){
						String temp2[] = accInfo.split(",");
						for (int k = 0; k < temp2.length; k++) {
							String temp3[] = temp2[k].split("/");
							
							int acc = Integer.parseInt(temp3[0]);
							int money = Integer.parseInt(temp3[1]);
							
							UserManager.instance.user[j].acc[k] = new Account();
							UserManager.instance.user[j].acc[k].num = acc;
							UserManager.instance.user[j].acc[k].money = money;
							
						}
					}
					j += 1;
				}
				
				
			}else {
				UserManager.instance.setdummy();
				setData();
				save();
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fr != null) { try {fr.close();} catch(IOException e) {}}
			if(br != null) { try {br.close();} catch(IOException e) {}}
		}
	}
	
}
