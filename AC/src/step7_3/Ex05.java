package step7_3;

class PrivateProduct{
	private String time;
	private String name;
	private int price;
	
	PrivateProduct(String time, String name, int price){
		this.time = time;
		this.name = name;
		this.price = price;
	}
	
	String getTime() {
		return time;
	}
	
	String getName() {
		return name;
	}
	int getPrice(){
		return price;
	}
	String getData() {
		return time + " " + name + " " + price;
	}
	
}

public class Ex05 {
	public static void main(String[] args) {
		PrivateProduct pp = new PrivateProduct("2020", "abc", 1000);
		
		//private로 막혔기때문에 한번 등록하면 값 변조가 불가
		// 오로지 가져오는것만 가능.
		
		
		
		System.out.println(pp.getTime());
		System.out.println(pp.getName());
		System.out.println(pp.getPrice());
		System.out.println(pp.getData());
	}

}
