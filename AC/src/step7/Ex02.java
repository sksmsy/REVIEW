package step7;

class Client{
	String name;
	int scr;
	
	void set_data(String n , int s) {
		this.name = n; this.scr = s;
	}
	void print_data() {
		System.out.println(this.name + " : "+this.scr);
	}
}

public class Ex02 {

	public static void main(String[] args) {
		Client [] st = new Client[3];
		for (int i = 0; i < st.length; i++) {
			st[i] = new Client();
		}
		
		st[0].set_data("김철수", 100);
		st[1].set_data("이만수", 20);
		st[2].set_data("박영희", 30);
		
		for (int i = 0; i < st.length; i++) {
			st[i].print_data();
		}
	}
}
