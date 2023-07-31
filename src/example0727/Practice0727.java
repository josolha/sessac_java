package example0727;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice0727 {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	/* 리펙토링
	 * 
	
		Practice0727 practice = new Practice0727();
		
		if(!practice.initKiosk(){
			return;
		}
		int storeCnt = practice.getStoreCountFromUser();
		Kiosk kiosk = new Kiosh(storeCnt);
		
		practice.processOrders(Kiosk);

	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("키오스크 키를 입력해주세요");
		int key = sc.nextInt();
		
			if(key == Kiosk.key) {
					System.out.println("매장 재고개수를 입력해주세요");
					int storeCnt = sc.nextInt();
					Kiosk kiosk = new Kiosk(storeCnt);
					
					while(true) {
					
						System.out.println("메뉴와 개수를 입력해주세요");
						String menu = sc.next();
						
						
						if(menu.equals("종료")) {
							System.out.println("프로그램을 종료 합니다.");
							break;
						}
						
						int cnt = sc.nextInt();
						if(kiosk.isInventory(cnt)) {
							Order order = kiosk.initOrder(menu, cnt);
							if(order ==null) {
								System.out.println("메뉴가 없습니다.");
								continue;
							}
							System.out.println(order.getPrice()+"원 입니다");
							int depositMoney = sc.nextInt();
							if(order.runOrder(depositMoney)){
								System.out.println("잔돈"+ (depositMoney -order.getPrice())+"와 "+order.getMenu()+"나왔습니다.");
								kiosk.subInventory(cnt);
							}
							else {
								System.out.println("금액이 부족합니다.");
							}
						}else {
							System.out.println("재고가 부족합니다.");
						}
					}
			}
			else {
				System.out.println("해당 키가 틀렸습니다.");
			}
	}
}


class Kiosk {
	
	final static int key = 3;
	int count;
	Map<String,Integer> orderHashMap;
	
	
	public Kiosk(int count) {
		super();
		this.count = count;
	}


	public boolean isInventory(int buyCnt) {
		if(buyCnt > this.count) {
			return false;
		}
		return true;
	}
	
	public void subInventory(int buyCnt) {
		this.count -= buyCnt;
	}
	
	public Order initOrder (String menu, int cnt){
		//메뉴 만들고 가격 설정하기
		orderHashMap = new HashMap<>();
		orderHashMap.put("딸기요거트", 4500);
		orderHashMap.put("밀크티", 3500);
		orderHashMap.put("카페라떼", 3500);
		orderHashMap.put("아메리카노", 2000);
		
		int price = 0;
		
		if(orderHashMap.containsKey(menu)) {
			price = orderHashMap.get(menu);
			//subInventory(cnt);
		}else {
			return null;
		}
	
		return new Order(menu, cnt, price);
	}
	
}

class Order{
	String menu;
	int cnt;
	int price;
	
	public Order(String menu, int cnt, int price) {
		this.menu = menu;
		this.cnt = cnt;
		//price
		setOrderPrice(price);
	}
	public void setOrderPrice(int price) {
		this.price = this.cnt * price;
		
	}
	public boolean runOrder(int depositMoney) {
		if(depositMoney > price) {
		   return true;
		}
		return false;
	}
	
	public int getPrice() {
		return this.price;	
	}
	public String getMenu() {
		return menu;
	}
	
}


