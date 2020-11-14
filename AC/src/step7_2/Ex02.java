package step7_2;

class Test{
	int num;
	int size;
	char[] data;
	
	void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}

public class Ex02 {

	public static void main(String[] args) {

		String data ="6\n";
		data += "0/2/a/b\n";
		data += "1/3/a/b/c\n";
		data += "2/5/a/b/c/d/e\n";
		data += "3/4/a/b/c/d\n";
		data += "4/3/a/b/c\n";
		data += "5/1/a";
		System.out.println(data);	

		Test[] t;	
		
		String temp [] = data.split("\n");
		int cnt = Integer.parseInt(temp[0]);
		
		t = new Test[cnt];
		
		for (int i = 0; i < cnt; i++) {
			t[i] = new Test();
		}
		
		for (int i = 0; i < cnt; i++) {
			String[] info = temp[i+1].split("/");
			
			t[i].num = Integer.parseInt(info[0]);
			t[i].size = Integer.parseInt(info[1]);
			
			
			t[i].data = new char[t[i].size];
			int k = 2;
			for (int j = 0; j < t[i].data.length; j++) {
				t[i].data[j] = info[k].charAt(0);
				k += 1;
			}
		}
		
		for (int i = 0; i < cnt; i++) {
			t[i].print();
		}
		
		
		
	}

}
