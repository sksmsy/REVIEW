package step7;

class Client{
	String name;
	int scr;
	
	void set_data(String n, int s) {
		this.name = n; this.scr = s;
	}
	
	void print_data () {
		System.out.println(this.name + " : " + this.scr);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		
		Client c[] = new Client[3];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = new Client();
		}
		
		c[0].set_data("aaaa", 100);
		c[1].set_data("bbbb", 90);
		c[2].set_data("cccc", 80);
		
		
		for (int i = 0; i < c.length; i++) {
			c[i].print_data();
		}
	}
}
