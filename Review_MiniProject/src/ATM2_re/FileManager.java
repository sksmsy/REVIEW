package ATM2_re;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	static FileManager instance = new FileManager();
	
	String FileName = "ATM2_re.txt";
	String data ="";
	
	void setData() {
		
		UserManager u = UserManager.instance;
		data = "";
		int cnt =UserManager.instance.userCnt;
		data += cnt;
		data += "\n";
		
		for (int i = 0; i < cnt; i++) {
			data += u.userList[i].id +"/"+ u.userList[i].pw;
			data+= "\n";
			if(u.userList[i].accCnt == 0) {
				data += "0";
			}else {
				data+=u.userList[i].accCnt;
				data +="\n";
				for (int j = 0; j < u.userList[i].accCnt; j++) {
					data += u.userList[i].accList[j].num;
					data += "/";
					data += u.userList[i].accList[j].money;
					
					if(j!= u.userList[i].accCnt-1) {
						data += ",";
					}
				}
			}
			if(i != u.userCnt -1) {
				
				data += "\n";
			}
		}
		//data = data.substring(0, data.length()-1);
	}
	
	void saveData() {
		setData();
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(FileName);
			fw.write(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw != null) { try { fw.close();}catch (IOException e) {}}
		}
	}
	
	void loadData() {
		File file = new File(FileName);
		FileReader fr  = null;
		BufferedReader br = null;
		
		
		
		if(file.exists()) {
			
			UserManager.instance.userList = null;
			
			try {
			
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String line = br.readLine();;
				int userCnt = Integer.parseInt(line);
				UserManager.instance.userList = new User[userCnt];
				UserManager.instance.userCnt = 0;
				
				while(true) {
					line = br.readLine();
					
					if(line == null) {
						break;
					}
					data += line;
					data +="\n";
				}
				
				String temp[] = data.split("\n");
				
				User u[] = UserManager.instance.userList;
				for (int i = 0; i < userCnt; i++) {
					u[i] = new User();
				}
				
				int j = 0;
				for (int i = 0; i < userCnt; i++) {
					String temp2[] = temp[j].split("/");
					
					u[i].id = temp2[0];
					u[i].pw = temp2[1];
					
					if(temp[j+1].equals("0")) {
						u[i].accCnt = 0;
						j+=2;
					}else {
						u[i].accCnt = Integer.parseInt(temp[j+1]);
						
						u[i].accList = new Account[u[i].accCnt];
						
						String temp3[] = temp[j+2].split(",");
						for (int k = 0; k < u[i].accCnt; k++) {
							String info[] = temp3[k].split("/");
							
							u[i].accList[k] = new Account();
							u[i].accList[k].num = info[0];
							u[i].accList[k].money = Integer.parseInt(info[1]);
						}
						j+=3;
					}
					
					
				}
				
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(fr != null) {try {fr.close();}catch (IOException e) {}}
				if(br != null) {try {br.close();}catch (IOException e) {}}
			}
		}else {
			UserManager.instance.setDummy();
			FileManager.instance.saveData();
		}
		
	}
}
