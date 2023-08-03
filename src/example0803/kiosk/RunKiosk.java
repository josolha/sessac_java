package example0803.kiosk;

import java.util.*;

public class RunKiosk {

    static Scanner sc = new Scanner(System.in);
    private static final String INVENTORY_MSG = "매장 재고개수를 입력해주세요";
    private static final String ORDER_TYPE_MSG = "1.배달 2.포장 3.매장 주문방식 번호를 입력해주세요";
    private static final String MENU_MSG = "메뉴 또는 주문을 입력해주세요";
    private static final String INVALID_SERVICE_MSG = "없는 주문 서비스 입니다.";


    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk(storeInventoryCnt());

        try {
            while (true) {

                String type = orderType();

                getUserMenus(kiosk);

                if(!kiosk.isInventory(kiosk.getMenusSize())){
                    break;
                }
                Order orderService =kiosk.initOrder(type);
                if(orderService ==null){
                    System.out.println(INVALID_SERVICE_MSG);
                    break;
                }
                handleOrderType(type,orderService);
                kiosk.subInventory(kiosk.getMenusSize());
                checkData(orderService);
                kiosk.clearMenuList();

                System.out.println(kiosk.toString());
             }
         } catch(CustomException e){
            System.out.println(e.getMessage());
         }
    }

    private static <T> void checkData(Order order) {
        //Data체킹
        System.out.println("\n=========Data Check==========");
        System.out.println("주문음료 = " + order.orderMenu.toString());
        System.out.println("총 주문가격 = " + order.getTotalPrice());
        System.out.println("=============================\n");
    }

    private static void handleHereOrderType(Order orderService) {
        orderService.calculateTotalPrice();
        System.out.println(orderService.getTotalPrice()
                            + "원 입니다. "
                            + "\n금액을 결제해주세요");
        int priceForHere = sc.nextInt();
        System.out.println("주문번호를 입력해주세요");
        int orderNum = sc.nextInt();
        ((HereOrder) orderService).setOrderNum(orderNum);
        if (orderService.runOrder(priceForHere)) {
            System.out.println("잔돈"
                    + (priceForHere - orderService.getTotalPrice())
                    + "원 입니다.");
            ((HereOrder) orderService).successHere();
        }
        else {
            System.out.println("금액이 부족합니다.");
        }

    }

    private static void handleTakeoutOrder(Order orderService) {
        orderService.calculateTotalPrice();
        System.out.println("테이크 아웃은 500" +
                            "원 할인되어 "
                            + orderService.getTotalPrice()
                            + "원 입니다."
                            +"\n금액을 결제해주세요");
        int getPrice = sc.nextInt();
        if (orderService.runOrder(getPrice)) {
            System.out.println("포장시간을 입력해주세요");
            int time = sc.nextInt();
            ((TakeoutOrder) orderService).setTime(time);
            System.out.println("잔돈 "
                             + (getPrice - orderService.getTotalPrice())
                             + "원 입니다.");
            ((TakeoutOrder) orderService).successTakeout();
        }else{
            System.out.println("금액이 부족합니다.");
        }
    }

    private static void handleDeliveryOrder(Order orderService) {
        orderService.calculateTotalPrice();
        System.out.println(
                        "배달비 "+
                        (((DeliveryOrder) orderService).getDeliveryFee())+
                        "원 추가되어 "+
                         orderService.totalPrice+
                        "원 입니다");
        System.out.println("배달은 정확한 금액을 결제해주세요");
        int getPrice = sc.nextInt();
        System.out.println("주소를 입력해주세요");
        String getAddress = sc.next();
        if(orderService.runOrder(getPrice)){
            ((DeliveryOrder) orderService).setLocate(getAddress);
            ((DeliveryOrder) orderService).successDelivery();
        }else {
            System.out.println("금액이 다릅니다.");
        }
    }

    private static void handleOrderType(String type, Order orderService) {
        switch (type) {
            case "Delivery":
                handleDeliveryOrder(orderService);
                break;
            case "TakeoutOrder":
                handleTakeoutOrder(orderService);
                break;
            case "HereOrder":
                handleHereOrderType(orderService);
                break;
        }
    }

    private static void getUserMenus(Kiosk kiosk) throws CustomException {

        while(true){
            System.out.println(MENU_MSG);
            String menu = sc.next();
            if(menu.equals("주문")) break;
            if(kiosk.getMenusSize()==10){
                System.out.println("최대 10개까지 주문 가능합니다.");
                break;
            }
            kiosk.addMenus(menu);
        }

    }

    private static String orderType() {
        System.out.println(ORDER_TYPE_MSG);

        Map<Integer, String> orderType = new HashMap<>();
        orderType.put(1, "Delivery");
        orderType.put(2, "TakeoutOrder");
        orderType.put(3, "HereOrder");

        int userType = sc.nextInt();

        return orderType.get(userType);
    }

    private static int storeInventoryCnt() {
        System.out.println(INVENTORY_MSG);
        return sc.nextInt();
    }
}
