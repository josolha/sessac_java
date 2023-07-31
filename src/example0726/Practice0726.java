package example0726;
;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Practice0726 {
	
	static Random random;
	static Scanner sc = new Scanner(System.in);
	static Map<String,Integer> orderHashMap;
	static Map<String,Integer> gameHashMap;
	static List<String> lottoList;

	public static void main(String[] args) {
		final String menuBar = "========================\n"
								+ "���Ͻô� �׸��� �Է��ϼ���.\n"
								+ "1:ORDER \n"
								+ "2:GAME \n"
								+ "3:GUGUDAN \n"
								+ "4:LOTTO \n"
								+"========================";
		
		final String endBar = "========================\n"
		     					+"���Ͻô� �׸��� �����ϼ���.\n"
		     					+ "1:����\n"
								+ "2:�ٽ�\n"
								+"========================\n";
		
		boolean flag = true;
		
		while (flag) {
		
		try {
			Practice0726 instance = new Practice0726();
			
				
			System.out.println(menuBar);
			int startChoice = inputNumberCheck(1,4);
			
				if(startChoice== 1) {
					instance.order();
					
				}else if (startChoice ==2) {
					instance.game();
					
				}else if(startChoice==3) {
					instance.gugudan();
					
				}else if(startChoice ==4) {
					instance.radomLotto();
				}
				
			System.out.println(endBar);
			
			int endCheck = inputNumberCheck(1,2);
			
				if(endCheck == 1) {
					flag=false;
					System.out.println("����Ǿ����ϴ�.");
				}
				
		   }catch(Exception e) {
			
			  System.out.println(e.getMessage());
			
		   }
		}
	}
	
		public void order() throws Exception {
			Practice0726.setMenu();
			
			System.out.print("���� �޴��� �Է��ϼ���:");
			String menu = sc.next();
	
			if (!orderHashMap.containsKey(menu)) {
				throw new Exception("�˼��մϴ�. �ش� �޴��� �������� �ʽ��ϴ�.\n");
			}
			
		
			while(true) {
				int cnt = receiveOrder(menu);
				int totalPrice = orderHashMap.get(menu) * cnt;
	
				System.out.println(menu +" "+cnt+"���� ��"+ totalPrice+"�� �Դϴ�.");
				
				if(changeMoney(totalPrice, menu, cnt)) {
					break;
				}
			}
		}
		public static void setMenu() {
			orderHashMap = new HashMap<>();
			orderHashMap.put("������Ʈ", 4500);
			orderHashMap.put("��ũƼ", 3500);
			orderHashMap.put("ī���", 3500);
			orderHashMap.put("�Ƹ޸�ī��", 2000);
			
		}

		public int receiveOrder(String menu) {
			System.out.print("��� �帱���?");
			int cnt = inputNumberCheck(1, 100);
			return cnt;
		}

		public boolean changeMoney(int totalPrice, String menu, int cnt) throws Exception {
			System.out.print("���� �ݾ��� �Է��� �ּ���: ");
			int money = inputNumberCheck(0, 1000000);
	
			int change = money - totalPrice;
			if(change <0) {
				System.out.println("�ݾ��� �����մϴ�.\n");
				return false;
			} else {
				System.out.println("�ܵ��� " + change +"�Դϴ�.\n");
				for (int i = 0; i < cnt; i++) {
					System.out.println(menu + "���Խ��ϴ�");
				}
				return true;
			}
		}
		
		
		public void game() throws Exception{
			gameHashMap = new HashMap<>();
			gameHashMap.put("����", 1);
			gameHashMap.put("����", 2);
			gameHashMap.put("��", 3);
			
			System.out.println("���� ���� �� �����Դϴ�. ����:1, ����:2, ��:3");
			
			System.out.print("a ������ ��ȣ�� �������ּ��� :");
			int aUser = inputNumberCheck(1, 3);
			
			System.out.print("b ������ ��ȣ�� �������ּ��� :");
			int bUser = inputNumberCheck(1, 3);
			
			String result = winner(aUser,bUser);
			System.out.println(result);
				
		}
		
		public String winner(int a, int b) throws Exception{
			String result ="";
			
			if(a == b) {
				result = "�����ϴ� \n";
			}else {
				if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
					result = "A ������ �̰���ϴ� \n";
				} else if ((a == 3 && b == 1) || (a == 1 && b == 2) || (a == 2 && b == 3)) {
					result = "B ������ �̰���ϴ� \n";
				} else {
					throw new Exception("�߸��� �Է��Դϴ�.\n");
				}
			}
			return result;
		}
		
		public void gugudan() {
			System.out.println("�������� �����ϰڽ��ϴ�.\n���ڸ� �Է����ּ���");
			int a = inputNumberCheck(1,19);
			for (int i = 1; i < a; i++) {
				if(i%2!=0) {
					System.out.println(a +" X " +i+" = " +a*i );
				}
			}
			System.out.println();
		}
		
		public void radomLotto() {
			random = new Random();
			
			System.out.println("�ζ� ������ �帱���?");
			int cntLotto = inputNumberCheck(1, 5);
			for (int i = 0; i < cntLotto; i++) {
				lottoList = new ArrayList<>();
				 for (int j = 0; j < 6; ) {
			            int num = random.nextInt(45) + 1;
			            if (!lottoList.contains(Integer.toString(num))) {
			                lottoList.add(Integer.toString(num));
			                j++;
			            }
			        }
				System.out.println((i+1)+"��°�� �ζ� : "+lottoList);
			}
		}
		
		public static int inputNumberCheck(int min, int max) {
		    while (true) {
		 
		        	int input = sc.nextInt();
		        	  if (input < min || input > max) {		           
		        		  sc.nextLine();  //nextInt() �޼��带 ȣ������ �� �Է��� �ùٸ��� ������, �� �Է��� ������ ���ۿ� ���� ����.
				            System.out.println("�߸��� �Է��Դϴ�. " + min + "���� " + max + "������ ���ڸ� �Է����ּ���.");
		        	  }else {
		        		  return input;
		        }
		    }
		}
		
 }
	

