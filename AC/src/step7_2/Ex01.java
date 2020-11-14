package step7_2;

class Student{
	String name;
	int scr;
	
	void print() {
		System.out.println(name + " : " + scr);
	}		
}

public class Ex01 {

	public static void main(String[] args) {
		
		String data = "3\n";
		data += "김영희/30\n";
		data += "이만수/40\n";
		data += "이철민/60";
		
		System.out.println(data);
		System.out.println("-----------------");
		
		
		
		Student[] st;
	
		String[] temp = data.split("\n");
		int cnt = Integer.parseInt(temp[0]);
		
		st = new Student[cnt];
		for (int i = 0; i < cnt; i++) {
			st[i] = new Student();
		}
		
		for (int i = 0; i < cnt; i++) {
			String value[] = temp[i+1].split("/");
			
			st[i].name = value[0];
			st[i].scr = Integer.parseInt(value[1]);
			
			st[i].print();
		}
		System.out.println();
		
		
		
		int min = st[0].scr;
		int minIdx = 0;
		
		
		for (int i = 0; i < cnt; i++) {
			if(min > st[i].scr) {
				min = st[i].scr;
				minIdx = i;
			}
		}
		
		Student[] temp2 = st;
		st = new Student[cnt-1];
		
		int j = 0;
		for (int i = 0; i < cnt; i++) {
			if(minIdx != i){
				st[j] = temp2[i];
				j += 1;
			}
		}
		cnt -= 1;
		
		for (int i = 0; i < cnt; i++) {
			st[i].print();
		}
		
		
		
		
		
	}

}
