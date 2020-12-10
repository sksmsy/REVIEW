package rpg_final;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileData {

	// 저장 메서드
	void save() throws IOException {
		UnitManager um = UnitManager.instance;
		
		FileWriter fout = null;
		String path = "gameData.txt";
		fout = new FileWriter(path);
		Vector<Player> temp = um.player.getGuildList();
		String gameData = "";
		gameData += Player.money;
		gameData += "\r\n";
		gameData += temp.size();
		gameData += "\r\n";

		// 플레이어의 길드원 저장
		for (int i = 0; i < temp.size(); i++) {
			gameData += temp.get(i).name;
			gameData += "/";
			gameData += temp.get(i).level;
			gameData += "/";
			gameData += temp.get(i).maxHp;
			gameData += "/";
			gameData += temp.get(i).att;
			gameData += "/";
			gameData += temp.get(i).def;
			gameData += "/";
			gameData += temp.get(i).exp;
			gameData += "/";
			gameData += temp.get(i).party;
			gameData += "\r\n";
			// 무기, 갑옷, 반지가 비어있지 않으면 종류, 이름, 능력, 가격까지 저장하기
			if (temp.get(i).weapon == null) {
				gameData += temp.get(i).weapon;
			} else {
				Item item = temp.get(i).weapon;
				String weaponData = "";
				weaponData += item.kind;
				weaponData += ",";
				weaponData += item.name;
				weaponData += ",";
				weaponData += item.power;
				weaponData += ",";
				weaponData += item.price;
				gameData += weaponData;
			}
			gameData += "/";
			if (temp.get(i).armor == null) {
				gameData += temp.get(i).armor;
			} else {
				Item item = temp.get(i).armor;
				String armorData = "";
				armorData += item.kind;
				armorData += ",";
				armorData += item.name;
				armorData += ",";
				armorData += item.power;
				armorData += ",";
				armorData += item.price;
				gameData += armorData;
			}
			gameData += "/";
			if (temp.get(i).ring == null) {
				gameData += temp.get(i).ring;
			} else {
				Item item = temp.get(i).ring;
				String ringData = "";
				ringData += item.kind;
				ringData += ",";
				ringData += item.name;
				ringData += ",";
				ringData += item.power;
				ringData += ",";
				ringData += item.price;
				gameData += ringData;
			}
			gameData += "\r\n";
		}

		// 소지한 아이템 개수
		gameData += Player.getItemSize();
		gameData += "\r\n";

		// 아이템 저장
		for (int i = 0; i < Player.getItemSize(); i++) {
			Item item = Player.getItemList().get(i);

			gameData += item.kind;
			gameData += "/";
			gameData += item.name;
			gameData += "/";
			gameData += item.power;
			gameData += "/";
			gameData += item.price;
			gameData += "\r\n";
		}
		System.out.println(gameData);
		// fout.write(str, off, len);
		// 주어진 문자열 off 순번부터 len개까지의 문자 보냄]
		fout.write(gameData, 0, gameData.length());
		fout.close();
	}

	// 불러오기 메서드
	void loadData() throws IOException {
		File file = null;
		FileReader reader = null;
		BufferedReader br = null;
		String path = "gameData.txt";
		file = new File(path);
		if (file.exists()) {
			reader = new FileReader(path);
			br = new BufferedReader(reader);
			
			// 플레이어 소지금
			String money = br.readLine();
			Player.money = Integer.parseInt(money); 
			System.out.println(Player.money);
			
			// 길드원 수 
			String guildSize = br.readLine();
			int size = Integer.parseInt(guildSize);
			Player.guild.guildList.clear(); // 길드원리스트 초기화
			System.out.println(size);
			
			// 길드원, 아이템 내용 가져와서 저장하기
			for (int i = 0; i < size; i++) {
				//==================== Unit =======================
				String unitData = br.readLine();
				// 길드원 배열
				String [] unitArr = unitData.split("/");
				// 이름/레벨/최대HP/공격/방어/경험치/파티유무
				String name = unitArr[0];
				int level = Integer.parseInt(unitArr[1]);
				int maxhp = Integer.parseInt(unitArr[2]);
				int att = Integer.parseInt(unitArr[3]);
				int def = Integer.parseInt(unitArr[4]);
				int exp = Integer.parseInt(unitArr[5]);
				boolean party = Boolean.parseBoolean(unitArr[6]);
				// 길드원을 길드리스트에 저장하기
				Player temp = new Player(name, level, maxhp, att, def, exp, party);
				Player.guild.guildList.add(temp);
				
				//==================== item =======================
				String itemData = br.readLine();			
				String itemArr[] = itemData.split("/");	
				// 무기 저장
				if(itemArr[0].equals("null")) {
					Player.getGuildList().get(i).weapon = null;						
				}
				else {
					// 종류,이름,능력,가격
					String[] weapon = itemArr[0].split(",");
					int itemKind = Integer.parseInt(weapon[0]);
					String itemName = weapon[1];
					int itemPower =  Integer.parseInt(weapon[2]);
					int itemPrice =  Integer.parseInt(weapon[3]);
					// 무기를 아이템 객체에 저장 후 길드원에게 넣어주기
					Item item = new Item();
					item.setItem(itemKind , itemName , itemPower , itemPrice);
					Player.getGuildList().get(i).weapon = item;
				}
				// 갑옷 저장
				if(itemArr[1].equals("null")) {
					Player.getGuildList().get(i).armor = null;						
				}
				else {
					// 종류,이름,능력,가격
					String[] armor = itemArr[1].split(",");
					int itemKind = Integer.parseInt(armor[0]);
					String itemName = armor[1];
					int itemPower =  Integer.parseInt(armor[2]);
					int itemPrice =  Integer.parseInt(armor[3]);
					// 갑옷을 아이템 객체에 저장 후 길드원에게 넣어주기
					Item item = new Item();
					item.setItem(itemKind , itemName , itemPower , itemPrice);
					Player.getGuildList().get(i).armor = item;
				}
				// 장신구 저장
				if(itemArr[2].equals("null")) {
					Player.getGuildList().get(i).ring = null;						
				}
				else {
					// 종류,이름,능력,가격
					String[] ring = itemArr[1].split(",");
					int itemKind = Integer.parseInt(ring[0]);
					String itemName = ring[1];
					int itemPower =  Integer.parseInt(ring[2]);
					int itemPrice =  Integer.parseInt(ring[3]);
					// 갑옷을 아이템 객체에 저장 후 길드원에게 넣어주기
					Item item = new Item();
					item.setItem(itemKind , itemName , itemPower , itemPrice);
					Player.getGuildList().get(i).ring = item;
				}
			}
			//==================== inventory =======================
			String invenSize = br.readLine();
			System.out.println(invenSize);
			int inSize = Integer.parseInt(invenSize);
			
			// 플레이어의 인벤토리 아이템 리스트 초기화
			Player.inven.itemList.clear();
			
			for(int i = 0; i < inSize; i++) {
				String invenDate = br.readLine();
				// 종류/이름/능력/가격
				String [] invenArr = invenDate.split("/");
				int itemKind = Integer.parseInt(invenArr[0]);
				String itemName = invenArr[1];
				int itemPower =  Integer.parseInt(invenArr[2]);
				int itemPrice =  Integer.parseInt(invenArr[3]);
				// 아이템을 객체에 저장 후 플레이어 인벤토리에 추가하기
				Item item = new Item();
				item.setItem(itemKind , itemName , itemPower , itemPrice);
				Player.inven.itemList.add(item);
			}
		}
	}
}
