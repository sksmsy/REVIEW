package step8;

import java.util.ArrayList;

class Member{
	private int custno;				//회원번호
	private String custname;		//회원이름
	private String phone;			//전화
	private String address;			//통신사
	private String joindate;		//가입일자
	private String grade;			//등급
	private String city;			//거주도시
	
	public Member() {}
	public Member(int custno, String custname, String phone,
					String address, String joindate, String grade,
					String city) {
		
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
	
	void print() {
		System.out.println(custno + " / " + custname + "/");
	}
	
	String get_name() {
		
		return custname;
	}
	
	int get_num() {
		
		return custno;
	}
	
	void set_num(int num) {
		custno = num;
	}
}
	
class Money{
	int custno;				
	int saleno;				
	int pcost;				
	int amount;				
	int price;				
	String pcode;			
	String sdate;
	
	public Money() {}
	public Money(int custno, int saleno, int pcost, int amount,
			int price, String pcode, String sdate) {
		
		this.custno = custno;			//회원번호
		this.saleno = saleno;			//판매번호
		this.pcost = pcost;				//단가
		this.amount = amount;			//수량
		this.price = price;				//매출
		this.pcode = pcode;				//상품코드
		this.sdate = sdate;				//판매일자
			
	}
	
	
	void money_p() {
		System.out.println(custno + " / " + price + " / "+ amount);
	}
}

class Total{
	int custno;
	String custname;
	int totalPrice;
	
	public Total(int custno, int totalPrice, String custname) {
		
		this.custname = custname;
		this.custno = custno;
		this.totalPrice = totalPrice;
	}
	
	void print() {
		
		System.out.println(custno +"\t"+ custname + "\t" +totalPrice);
		System.out.println("---------------------------------------");
	}
}

	
class MemberManager{
	ArrayList<Member> memberList = new ArrayList<Member>();
	ArrayList<Money> moneyList = new ArrayList<Money>();
	ArrayList<Total> totalList = new ArrayList<Total>();

	void init() {
		memberList.add(new Member(100001, "김행복", "010-1111-2222", "SK", "20151202", "A", "01"));
		memberList.add(new Member(100002, "이축복", "010-1111-3333", "SK", "20151206", "B", "01"));
		memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SK", "20151001", "B", "30"));
		memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SK", "20151113", "A", "30"));
		memberList.add(new Member(100005, "진평화", "010-1111-6666", "SK", "20151225", "B", "60"));
		memberList.add(new Member(100006, "차공단", "010-1111-7777", "SK", "20151211", "C", "60"));
		
		moneyList.add(new Money(100001, 20160001, 500, 5, 2500, "A001", "20160101"));
		moneyList.add(new Money(100001, 20160002, 1000, 4, 4000, "A002", "20160101"));
		moneyList.add(new Money(100001, 20160003, 500, 3, 1500, "A008", "20160101"));
		moneyList.add(new Money(100002, 20160004, 2000, 1, 2000, "A004", "20160102"));
		moneyList.add(new Money(100002, 20160005, 500, 1, 500, "A001", "20160103"));
		moneyList.add(new Money(100003, 20160006, 1500, 2, 3000, "A003", "20160103"));
		moneyList.add(new Money(100004, 20160007, 500, 2, 1000, "A001", "20160104"));
		moneyList.add(new Money(100004, 20160008, 300, 1, 300, "A005", "20160104"));
		moneyList.add(new Money(100004, 20160009, 600, 1, 600, "A006", "20160104"));
		moneyList.add(new Money(100004, 20160010, 3000, 1, 3000, "A007", "20160106"));
		}
	
	void print() {
		for (int i = 0; i < totalList.size(); i++) {
			totalList.get(i).print();
		}
		
		
	}
	
	
	void total() {
		
		
		for (int i = 0; i < memberList.size(); i++) {
			int tot = 0;
			for (int j = 0; j < moneyList.size(); j++) {
				if(memberList.get(i).get_num() == moneyList.get(j).custno) {
					tot += moneyList.get(j).price;
					
				}
			}
			
			Total temp = new Total(memberList.get(i).get_num(), tot, memberList.get(i).get_name());
			totalList.add(temp);
		}
	}
	
	void sort_total() {
		
		int top =0;
		int ch = 0;
		
		for (int i = 0; i < totalList.size(); i++) {
			for (int j = 0; j < i; j++) {
				if(totalList.get(i).totalPrice > top) {
					top = totalList.get(i).totalPrice;
					
				}
			}
		}
		
	}
	
	
	      
	
	
}

	
	



public class test1 {

	public static void main(String[] args) {
		MemberManager mg = new MemberManager();
		mg.init();
		mg.total();
		mg.print();
		
	}

}
