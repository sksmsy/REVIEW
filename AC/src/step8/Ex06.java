package step8;

class MyArrayList{
	Tv[] arr;
	int cnt;
	
	void add(Tv e) {
		if(cnt == 0) {
			arr= new Tv[cnt+1];
		}else if(cnt > 0) {
			Tv[]temp = arr;
			arr = new Tv[cnt+1];
			
			for (int i = 0; i < cnt; i++) {
				arr[i] = temp[i];
			}
			temp = null;
		}
		arr[cnt] = e;
		cnt += 1;
	}
	
	int size() {
		return cnt;
	}
	
	void remove(int idx) {
		if(cnt == 1) {
			arr = null;
			cnt = 0;
		}else if(cnt > 1) {
			Tv[] temp = arr;
			
			arr = new Tv[cnt - 1] ;
			int j = 0;
			for (int i = 0; i < cnt; i++) {
				if(i != idx) {
					arr[j] = temp[i];
					j+=1;
				}
			}
		}
		cnt -= 1;
	}
	
	Tv get(int idx) {
		return arr[idx];
	}
	
}
public class Ex06 {
	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList();
		Tv temp = new Tv("TV", "삼성", 1000);
		myList.add(temp);

		temp = new Tv("시그니처TV", "엘지", 2000);
		myList.add(temp);

		temp = new Tv("스마트TV", "애플", 3000);
		myList.add(temp);

		int cnt = myList.size();
		
		for (int i = 0; i < cnt; i++) {
			System.out.println(myList.get(i).name);
		}
	}
}
