package example0727;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice0727_refactoring {
	
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Practice0727_refactoring practice = new Practice0727_refactoring();
		
		//1.Ű����ũ Ű �Է�
		if(!practice.initKiosk()){
			return;
		}

		//2.���� ��� �Է�
		int storeCnt = practice.getStoreCountFromUser();
		
		//3.���� ��� ���� 
		Kiosk2 kiosk = new Kiosk2(storeCnt);
		
		//4.�ֹ� �����Ͻ� ���� ���� , ����
		practice.processOrders(kiosk);

	}
	public boolean initKiosk() {
		System.out.println("Ű����ũ Ű�� �Է����ּ���");
		int key =sc.nextInt();
		if(key != Kiosk.key) {
			System.out.println("Ű�� Ʋ���ϴ�");
			return false;
		}
		return true;
	
	}
	public int getStoreCountFromUser() {
		System.out.println("���� ������� �Է����ּ���");
		return sc.nextInt();
	}
	
	
	public void processOrders(Kiosk2 kiosk) {
		while(true) {
            System.out.println("�޴��� ������ �Է����ּ���");
            String menu = sc.next();
            
            if(menu.equals("����")) {
                System.out.println("���α׷��� ���� �մϴ�.");
                break;
            }
            int cnt = sc.nextInt();
            Order2 order = kiosk.initOrder(menu, cnt);
            if(order == null) {
                System.out.println("�޴��� �����ϴ�.");
                continue;
            }
            if(!kiosk.isInventory(cnt)) {
                System.out.println("��� �����մϴ�.");
                continue;
            }
            executeOrder(kiosk, order, cnt);
        }
		
	}
	 public void executeOrder(Kiosk2 kiosk, Order2 order, int cnt) {
	        System.out.println(order.getPrice()+"�� �Դϴ�");
	        int depositMoney = sc.nextInt();
	        
	        if(order.runOrder(depositMoney)){
	            System.out.println("�ܵ�"+ (depositMoney -order.getPrice())+"�� "+order.getMenu()+"���Խ��ϴ�.");
	            kiosk.subInventory(cnt); //Ű����ũ ��� ���� 
	        } else {
	            System.out.println("�ݾ��� �����մϴ�.");
	        }
	 }
}

class Kiosk2 {
	
	final static int key = 3;
	int count;
	Map<String,Integer> orderHashMap;
	
	
	public Kiosk2(int count) {
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
	
	public Order2 initOrder (String menu, int cnt){
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
	
		return new Order2(menu, cnt, price);
	}
	
}

class Order2{
	String menu;
	int cnt;
	int price;
	
	public Order2(String menu, int cnt, int price) {
		this.menu = menu;
		this.cnt = cnt;
		//price
		setOrderPrice(price);
	}
	public void setOrderPrice(int price) {
		this.price = this.cnt * price;
		
	}
	public boolean runOrder(int depositMoney) {
		if(depositMoney >= price) {
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
