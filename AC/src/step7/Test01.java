package step7;
class Student{
	String name;
	int score[] = new int[3];
	int number;
	void print() {
		System.out.println(number + " " + name +" " +
				score[0]  + " " +  score[1]  + " " +  score[2] );;				
	}
}
public class Test01 {
	public static void main(String[] args) {
		int arr1[] = new int[3];
		// 학생 점수3개 저장 
		// 학생 번호와 점수 3개 
		int arr2[][] = new int[2][4];
		
		// 학생 이름3개와 번호와 점수3개 
		
		String names[] = new String[3];
		int score2[][] = new int[3][3];
		String addresss[] = new String[3];
		
		// 저둘을 합쳐주세요...
		
		
		Student st = new Student();
		st.name = "홍길동";
		st.score[0] = 100; st.score[1] = 20; st.score[2] = 40;
		st.number = 1001;
		
		// 그럼 출력좀해주세요.
		
		System.out.println(st.number + " " + st.name +" " +
		st.score[0]  + " " +  st.score[1]  + " " +  st.score[2] );;
		
		// 출력 쓸곳이 297군데에
		st.print();

		
		// 학생 여러명해주세요 .
		Student [] stlist = new Student[3];
		for(int i = 0; i < 3; i++) {
			stlist[i] = new Student();
		}
		
		
		
		
	}
}
