package example0727;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice0727 {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	/* �����丵
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
		System.out.println("Ű����ũ Ű�� �Է����ּ���");
		int key = sc.nextInt();
		
			if(key == Kiosk.key) {
					System.out.println("���� ������� �Է����ּ���");
					int storeCnt = sc.nextInt();
					Kiosk kiosk = new Kiosk(storeCnt);
					
					while(true) {
					
						System.out.println("�޴��� ������ �Է����ּ���");
						String menu = sc.next();
						
						
						if(menu.equals("����")) {
							System.out.println("���α׷��� ���� �մϴ�.");
							break;
						}
						
						int cnt = sc.nextInt();
						if(kiosk.isInventory(cnt)) {
							Order order = kiosk.initOrder(menu, cnt);
							if(order ==null) {
								System.out.println("�޴��� �����ϴ�.");
								continue;
							}
							System.out.println(order.getPrice()+"�� �Դϴ�");
							int depositMoney = sc.nextInt();
							if(order.runOrder(depositMoney)){
								System.out.println("�ܵ�"+ (depositMoney -order.getPrice())+"�� "+order.getMenu()+"���Խ��ϴ�.");
								kiosk.subInventory(cnt);
							}
							else {
								System.out.println("�ݾ��� �����մϴ�.");
							}
						}else {
							System.out.println("��� �����մϴ�.");
						}
					}
			}
			else {
				System.out.println("�ش� Ű�� Ʋ�Ƚ��ϴ�.");
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
		//�޴� ����� ���� �����ϱ�
		orderHashMap = new HashMap<>();
		orderHashMap.put("������Ʈ", 4500);
		orderHashMap.put("��ũƼ", 3500);
		orderHashMap.put("ī���", 3500);
		orderHashMap.put("�Ƹ޸�ī��", 2000);
		
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


