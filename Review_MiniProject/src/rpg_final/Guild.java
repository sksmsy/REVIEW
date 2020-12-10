package rpg_final;

import java.util.Random;
import java.util.Vector;

public class Guild {

	
	final int PARTY_SIZE = 3;
	Vector<Player> guildList = new Vector<>();
	Random r = new Random();
	Unit[] partyList;
	
	
	//길드원 생성 메서드
	
	void setGuild() {
		guildList.add(new Player("전사",1000,45,45,0));
		guildList.add(new Player("마법사",800,60,30,0));
		guildList.add(new Player("힐",500,70,30,0));
		
		//파티 참여 여부
		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).party = true;
		}
		
		playerList = new Unit[PARTY_SIZE];
		
		//길드원의 파티 참가 유무가 참이면 파티추가
		
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).party == true) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
	}
	
	//해당 길드원 가져오기
	Player getGuildUnit(int num) {
		return guildList.get(num);
	}

	//모든 길드원 능력치 출력
	public void printAllUnitStatus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.money + "]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).name + "]");
			System.out.print(" [레벨 : " + guildList.get(i).level + "]");
			System.out.print(" [체력 : " + guildList.get(i).hp);
			System.out.println(" / " + guildList.get(i).maxHp + "]");
			System.out.print("[공격력 : " + guildList.get(i).att + "]");
			System.out.print(" [방어력 : " + guildList.get(i).def + "]");
			System.out.println(" [파티중 : " + guildList.get(i).party + "]");
			System.out.println();
		}
		System.out.println("======================================");
	}
	
	//해당 길드원 능력치 출력 메서드
	public void printUnitStatus(int selUnit) {
		guildList.get(selUnit).printStatus();
	}
	
	//해당 길드원 아이템 출력 메서드
	public void printUnitItem(int selUnit) {
		guildList.get(selUnit).printEquitedItem();
	}
	
	//길드 메뉴
	public void guildMenu() {
		while(true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드 목록]\t\t[2.길드원 추가]\t\t[3.길드원 삭제]");
			System.out.println("[4.파티원 교체]\t\t[5.정렬]\t\t\t[0.뒤로가기]");
			int sel = GameManager.sc.nextInt();
			if (sel == 1) {
				printAllUnitStatus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 5) {
				unitSort ();
			} else if (sel == 0) {
				break;
			}
		}
	}
	
	public void buyUnit() {
		// 플레이어 소지금이 5000골드 이하면 길드원 추가 불가
		if (Player.money < 5000)
			return;
		String[] n1 = { "A", "B", "C", "D", "E", "F", "G" };
		String[] n2 = { "A", "B", "C", "D", "E", "F", "G" };
		String[] n3 = { "A", "B", "C", "D", "E", "F", "G" };

		// 랜덤 이름 정하기
		String name = n1[r.nextInt(n1.length)];
		name += n2[r.nextInt(n2.length)];
		name += n3[r.nextInt(n3.length)];

		// 랜덤 능력값 정하기
		int rNum = r.nextInt(8) + 2; // 2~10까지
		int hp = rNum * 11;
		int att = rNum + 1;
		int def = rNum / 2 + 1;

		// 길드원 추가하기
		Player temp = new Player(name, 1, hp, att, def, 0);
		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.money -= 5000;

	}
	
	public void removeUnit() {
		printAllUnitStatus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = GameManager.sc.nextInt() - 1;
		
		// 파티중인 길드원은 삭제 불가
		if (guildList.get(sel).party) {
			System.out.println("파티중인 멤버는 삭제할수 없습니다.");
		} else {
			System.out.println("=================================");
			System.out.print("[이름 : " + guildList.get(sel).name + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			guildList.remove(sel);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 파티원 출력 메서드
	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for(int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].name + "]");
			System.out.print(" [레벨 : " + partyList[i].level + "]");
			System.out.print(" [체력 : " + partyList[i].hp);
			System.out.println(" / " + partyList[i].maxHp + "]");
			System.out.print("[공격력 : " + partyList[i].att + "]");
			System.out.print(" [방어력 : " + partyList[i].def + "]");
			System.out.println(" [파티중 : " + guildList.get(i).party + "]");
			System.out.println();	
		}
		System.out.println("=====================================");
	}
	
	// 레벨 기준 정렬 메서드
	public void unitSort () {
		for (int i = 0; i < guildList.size(); i++) {
			Player temp = guildList.get(i);
			int index = i;
			for (int j = i; j < guildList.size(); j++) {
				if(temp.level < guildList.get(j).level) {
					temp = guildList.get(j);
					index = j;
				}
			}
			Player temp2 = guildList.get(index);
			guildList.set(index, guildList.get(i));
			guildList.set(i, temp2);
		}
		printAllUnitStatus();
	}
	// 파티원 교체 메서드
	public void partyChange() {
		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = GameManager.sc.nextInt()-1;
		
		// 길드원 능력값 출력
		printAllUnitStatus();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = GameManager.sc.nextInt()-1;
		
		// 교체 당한 파티원
		partyList[partyNum].party = false;
		
		// 교체된 파티원
		guildList.get(guildNum).party = true;
		
		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[partyNum].name + "]");
		System.out.print("에서 [이름 : " + guildList.get(guildNum).name + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");
		
		// 파티 재정의
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).party) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
