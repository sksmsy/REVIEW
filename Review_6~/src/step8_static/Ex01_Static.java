package step8_static;

import java.util.Vector;

class ST{
	int num;
	String name;
}

class St_Manager{
	static int cnt = 0;
	static Vector<ST> list = new Vector<ST>();
}



public class Ex01_Static {

	public static void main(String[] args) {
		
		ST st = new ST();
		st.num = 1001;
		st.name = "김철수";
		
		St_Manager.list.add(st);
		
		st = new ST();
		
		st.num = 1002;
		st.name = "박철수";
		
		St_Manager.list.add(st);
	}
}
