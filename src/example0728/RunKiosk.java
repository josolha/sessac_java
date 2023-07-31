package example0728;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunKiosk {
    static Scanner sc = new Scanner(System.in);
    static private Kiosk kiosk;
    static private Map<Integer, String> inputToOrderType;


    public static void main(String[] args) {

       kiosk = new Kiosk(getStoreCountFromUser());

       inputToOrderType = new HashMap<>();
       inputToOrderType.put(1, "Delivery");
       inputToOrderType.put(2, "TakeoutOrder");
       inputToOrderType.put(3, "HereOrder");

       while(true) {

           System.out.println("1.배달 2.포장 3.매장 주문방식 번호를 입력해주세요");

           int userInput = sc.nextInt();
           String orderType = inputToOrderType.get(userInput);

           System.out.println("메뉴와 개수를 입력해주세요");

           String menu = sc.next();
           int count = sc.nextInt();
           if(!kiosk.isInventory(count)){
               System.out.println("재고가 부족합니다.");
               continue;
           }
           Order orderService = kiosk.initOrder(orderType, menu, count);

           if (orderService == null) {
              System.out.println("메뉴가 없습니다.");
              continue;
           }
           orderService.setOrderPrice(); //주문 금액 세팅

           if (userInput == 1) {
               System.out.println("배달비 3000원 추가되어 "
                                 + orderService.getOrderPrice()
                                 + "원 입니다"
                                 +"\n배달 주문은 정확한 금액을 결제해주세요");
               int priceForDeliver = sc.nextInt();
               if(((DeliveryOrder) orderService).runOrder(priceForDeliver)){
                   System.out.println("주소를 입력해주세요");
                   String userAddress = sc.next();
                   ((DeliveryOrder) orderService).setLocate(userAddress); //다운캐스팅
                   System.out.println(((DeliveryOrder) orderService).getLocate()
                                                  + " 주소로 "
                                                  + orderService.getOrderMenu()
                                                  + " 배달 주문이 완료 되었습니다.");
                   kiosk.subInventory(count);


                   //Data체킹
                   System.out.println("========example1.DeliveryOrder=========");
                   System.out.println("주문음료 = "+orderService.getOrderMenu());
                   System.out.println("주문개수 = "+orderService.getOrderCnt());
                   System.out.println("총 주문가격 = "+orderService.getOrderPrice());
                   System.out.println("배달주소= "+((DeliveryOrder) orderService).getLocate());
                   System.out.println("=============================");


               }else{
                   System.out.println("정확한 금액을 결제 부탁드립니다.");
               }
           } else if (userInput == 2) {
               System.out.println("테이크 아웃은 500원 할인되어 "
                                + orderService.getOrderPrice()
                                +"원 입니다."
                                +"\n금액을 결제해주세요.");
               int priceForTakeOut = sc.nextInt();
               if(orderService.runOrder(priceForTakeOut)) {
                   System.out.println("포장시간을 입력해주세요");
                   int time = sc.nextInt();
                   ((TakeoutOrder)orderService).setTime(time);
                   System.out.println("잔돈 "
                                + (priceForTakeOut- orderService.getOrderPrice())
                                + "원 입니다."
                                +"\n" +((TakeoutOrder)orderService).getTime()
                                + "분뒤 "
                                + orderService.getOrderMenu()
                                + " 포장주문 완료되었습니다");
                   kiosk.subInventory(count);

                   //Data체킹
                   System.out.println("========example1.TakeoutOrder=========");
                   System.out.println("주문음료 = "+orderService.getOrderMenu());
                   System.out.println("주문개수 = "+orderService.getOrderCnt());
                   System.out.println("총 주문가격 = "+orderService.getOrderPrice());
                   System.out.println("이동시간 = "+((TakeoutOrder) orderService).getTime());
                   System.out.println("=============================");

               }else {
                   System.out.println("금액이 부족합니다.");
               }
           } else {
               System.out.println(orderService.getOrderPrice()+"원 입니다. "
                                + "\n금액을 결제해주세요");
               int priceForHere = sc.nextInt();
               System.out.println("주문번호를 입력해주세요");
               int orderNum = sc.nextInt();
               ((HereOrder)orderService).setOrderNum(orderNum);
               if(orderService.runOrder(priceForHere)) {
                   System.out.println("잔돈"
                           + (priceForHere - orderService.getOrderPrice())
                           + "원 입니다."
                           + "\n"+((HereOrder)orderService).getOrderNum()
                           +" 주문번호로 "
                           + orderService.getOrderMenu()
                           + " 주문 완료 되었습니다.");
                   kiosk.subInventory(count);

                   //Data체킹
                   System.out.println("========example1.HereOrder=========");
                   System.out.println("주문음료 = "+orderService.getOrderMenu());
                   System.out.println("주문개수 = "+orderService.getOrderCnt());
                   System.out.println("총 주문가격 = "+orderService.getOrderPrice());
                   System.out.println("이동시간 = "+((HereOrder) orderService).getOrderNum());
                   System.out.println("=============================");

               }else{
                   System.out.println("주문번호가 틀렸습니다.");
               }
           }

       }
    }
    private static int getStoreCountFromUser() {
        System.out.println("매장 재고개수를 입력해주세요");
        return sc.nextInt();
    }

    /*
      private static boolean initKiosk() {
         System.out.println("키오스크 키를 입력해주세요");
         int key = sc.nextInt();

         if(key != example1.Kiosk.key) {
            System.out.println("해당 키가 틀렸습니다.");
            return false;
         }
         return true;
      }
    */

   }
