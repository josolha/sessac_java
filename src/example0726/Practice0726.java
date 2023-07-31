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
								+ "원하시는 항목을 입력하세요.\n"
								+ "1:ORDER \n"
								+ "2:GAME \n"
								+ "3:GUGUDAN \n"
								+ "4:LOTTO \n"
								+"========================";
		
		final String endBar = "========================\n"
		     					+"원하시는 항목을 선택하세요.\n"
		     					+ "1:종료\n"
								+ "2:다시\n"
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
					System.out.println("종료되었습니다.");
				}
				
		   }catch(Exception e) {
			
			  System.out.println(e.getMessage());
			
		   }
		}
	}
	
		public void order() throws Exception {
			Practice0726.setMenu();
			
			System.out.print("음료 메뉴를 입력하세요:");
			String menu = sc.next();
	
			if (!orderHashMap.containsKey(menu)) {
				throw new Exception("죄송합니다. 해당 메뉴는 존재하지 않습니다.\n");
			}
			
		
			while(true) {
				int cnt = receiveOrder(menu);
				int totalPrice = orderHashMap.get(menu) * cnt;
	
				System.out.println(menu +" "+cnt+"개는 총"+ totalPrice+"원 입니다.");
				
				if(changeMoney(totalPrice, menu, cnt)) {
					break;
				}
			}
		}
		public static void setMenu() {
			orderHashMap = new HashMap<>();
			orderHashMap.put("딸기요거트", 4500);
			orderHashMap.put("밀크티", 3500);
			orderHashMap.put("카페라떼", 3500);
			orderHashMap.put("아메리카노", 2000);
			
		}

		public int receiveOrder(String menu) {
			System.out.print("몇개를 드릴까요?");
			int cnt = inputNumberCheck(1, 100);
			return cnt;
		}

		public boolean changeMoney(int totalPrice, String menu, int cnt) throws Exception {
			System.out.print("내실 금액을 입력해 주세요: ");
			int money = inputNumberCheck(0, 1000000);
	
			int change = money - totalPrice;
			if(change <0) {
				System.out.println("금액이 부족합니다.\n");
				return false;
			} else {
				System.out.println("잔돈은 " + change +"입니다.\n");
				for (int i = 0; i < cnt; i++) {
					System.out.println(menu + "나왔습니다");
				}
				return true;
			}
		}
		
		
		public void game() throws Exception{
			gameHashMap = new HashMap<>();
			gameHashMap.put("가위", 1);
			gameHashMap.put("바위", 2);
			gameHashMap.put("보", 3);
			
			System.out.println("가위 바위 보 게임입니다. 가위:1, 바위:2, 보:3");
			
			System.out.print("a 유저의 번호를 선택해주세요 :");
			int aUser = inputNumberCheck(1, 3);
			
			System.out.print("b 유저의 번호를 선택해주세요 :");
			int bUser = inputNumberCheck(1, 3);
			
			String result = winner(aUser,bUser);
			System.out.println(result);
				
		}
		
		public String winner(int a, int b) throws Exception{
			String result ="";
			
			if(a == b) {
				result = "비겼습니다 \n";
			}else {
				if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
					result = "A 유저가 이겼습니다 \n";
				} else if ((a == 3 && b == 1) || (a == 1 && b == 2) || (a == 2 && b == 3)) {
					result = "B 유저가 이겼습니다 \n";
				} else {
					throw new Exception("잘못된 입력입니다.\n");
				}
			}
			return result;
		}
		
		public void gugudan() {
			System.out.println("구구단을 시작하겠습니다.\n숫자를 입력해주세요");
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
			
			System.out.println("로또 몇줄을 드릴까요?");
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
				System.out.println((i+1)+"번째줄 로또 : "+lottoList);
			}
		}
		
		public static int inputNumberCheck(int min, int max) {
		    while (true) {
		 
		        	int input = sc.nextInt();
		        	  if (input < min || input > max) {		           
		        		  sc.nextLine();  //nextInt() 메서드를 호출했을 때 입력이 올바르지 않으면, 그 입력은 여전히 버퍼에 남아 있음.
				            System.out.println("잘못된 입력입니다. " + min + "에서 " + max + "사이의 숫자를 입력해주세요.");
		        	  }else {
		        		  return input;
		        }
		    }
		}
		
 }
	

