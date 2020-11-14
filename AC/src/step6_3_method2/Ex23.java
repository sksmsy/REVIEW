package step6_3_method2;

class Student{
	int id;
	int scr;
	
	void print() {
		System.out.println(id + " : " + scr);
	}
}

class StudentManager{
	
	//1)리턴을 사용하지 않고 학생 저장
	Student student;
	
	void setStudentValue1(int x, int y) {
		student = new Student();
		student.id = x;
		student.scr = y;
	}

	
	//2)리턴을 사용하여 학생 저장
	Student setStudentValue2(int x , int y) {
		Student st = new Student();
		st.id = x;
		st.scr = y;
		return st;
	}
	
}
public class Ex23 {

	public static void main(String[] args) {

		StudentManager mng = new StudentManager();
		mng.setStudentValue1(1001, 30);
		mng.student.print();
		
		System.out.println("---------------------");
		
		Student st = mng.setStudentValue2(1001, 30);
		st.print();
		
	}

}
