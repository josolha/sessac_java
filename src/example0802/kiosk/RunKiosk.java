package example0802.kiosk;

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
                Menu[] menus = kiosk.setMenus(getMenus());

                if(!kiosk.isInventory(menus.length)){
                    break;
                }

                Order orderService =kiosk.initOrder(type,menus);

                if(orderService ==null){
                    System.out.println(INVALID_SERVICE_MSG);
                    break;
                }

                if(type.equals("Delivery")){
                    handleDeliveryOrder(orderService);
                }else if(type.equals("TakeoutOrder")){
                    handleTakeoutOrder(orderService);
                }else if(type.equals("HereOrder")){
                    handleHereOrderType(orderService);
                }
                kiosk.subInventory(menus.length);
                checkData(orderService);
             }
         } catch(CustomException e){
            System.out.println(e.getMessage());
         }

    }

    private static <T> void checkData(Order order) {
        //Data체킹
        System.out.println("\n=========Data Check==========");
        System.out.println("주문음료 = " + Arrays.toString(order.orderMenu));
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
                        "원 추가되어"+
                         orderService.totalPrice+
                        "원 입니다");
        System.out.println("배달은 정확한 금액을 결제해주세요");
        int getPrice = sc.nextInt();
        System.out.println("주소를 입력해주세요");
        String getAddress = sc.next();
        if(orderService.runOrder(getPrice)){
            ((DeliveryOrder) orderService).setLocate(getAddress);
            System.out.println(((DeliveryOrder) orderService).getLocate()+
                            " 주소로 배달 주문이 완료 되었습니다.");
            ((DeliveryOrder) orderService).successDelivery();
        }else {
            System.out.println("금액이 다릅니다.");
        }
    }

    private static void handleOrderType(String type, Order orderService) {
        if(type.equals("Delivery")){
            handleDeliveryOrder((DeliveryOrder) orderService);
        }
    }

    private static List<String> getMenus() {
        List<String> menuList = new ArrayList<>();

        while(menuList.size()<=10){
            System.out.println(MENU_MSG);
            String menu = sc.next();
            if(menu.equals("주문")){
                break;
            }
            menuList.add(menu);
        }
        return menuList;
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
