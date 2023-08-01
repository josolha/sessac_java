package example0731;

import example0731.CustomException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunKiosk {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("매장 재고개수를 입력해주세요");
        int storeCnt = sc.nextInt();

        Kiosk kiosk = new Kiosk(storeCnt);

        Map<Integer, String> inputToOrderType = new HashMap<>();
        inputToOrderType.put(1, "Delivery");
        inputToOrderType.put(2, "TakeoutOrder");
        inputToOrderType.put(3, "HereOrder");

        while (true) {

            try {
                System.out.println("1.배달 2.포장 3.매장 주문방식 번호를 입력해주세요");
                int userInput = sc.nextInt();
                String orderType = inputToOrderType.get(userInput);

                System.out.println("메뉴와 개수를 입력해주세요");
                String menu = sc.next();
                int count = sc.nextInt();

                Order orderService = kiosk.initOrder(orderType, menu, count);
                if (orderService == null) {
                    System.out.println("메뉴가 없습니다.");
                    continue;
                }
                if (!kiosk.isInventory(count)) {
                    System.out.println("재고가 부족합니다.");
                    continue;
                }
                if (userInput == 1) {
                    System.out.println("배달비 3000원 추가되어 "
                            + orderService.getTotalPrice()
                            + "원 입니다"
                            + "\n배달 주문은 정확한 금액을 결제해주세요");
                    int priceForDeliver = sc.nextInt();
                    if (orderService.runOrder(priceForDeliver)) {
                        System.out.println("주소를 입력해주세요");
                        String userAddress = sc.next();
                        ((DeliveryOrder) orderService).setLocate(userAddress);
                        ((DeliveryOrder) orderService).successDelivery();
                        kiosk.subInventory(count);

                        //Data체킹
                        System.out.println("\n========DeliveryOrder=========");
                        System.out.println("주문음료 = " + orderService.getOrderMenu());
                        System.out.println("주문개수 = " + orderService.getOrderCnt());
                        System.out.println("총 주문가격 = " + orderService.getTotalPrice());
                        System.out.println("배달주소= " + ((DeliveryOrder) orderService).getLocate());
                        System.out.println("=============================\n");

                    } else {
                        System.out.println("정확한 금액을 결제 부탁드립니다.");
                    }

                } else if (userInput == 2) {
                    System.out.println("테이크 아웃은 500원 할인되어 "
                            + orderService.getTotalPrice()
                            + "원 입니다."
                            + "\n금액을 결제해주세요.");
                    int priceForTakeOut = sc.nextInt();
                    if (orderService.runOrder(priceForTakeOut)) {
                        System.out.println("포장시간을 입력해주세요");
                        int time = sc.nextInt();
                        ((TakeoutOrder) orderService).setTime(time);
                        System.out.println("잔돈 "
                                + (priceForTakeOut - orderService.getTotalPrice())
                                + "원 입니다.");
                        ((TakeoutOrder) orderService).successTakeout();
                        kiosk.subInventory(count);

                        //Data체킹
                        System.out.println("\n========TakeoutOrder=========");
                        System.out.println("주문음료 = " + orderService.getOrderMenu());
                        System.out.println("주문개수 = " + orderService.getOrderCnt());
                        System.out.println("총 주문가격 = " + orderService.getTotalPrice());
                        System.out.println("주문시간= " + ((TakeoutOrder) orderService).getTime());
                        System.out.println("=============================\n");

                    } else {
                        System.out.println("금액이 부족합니다.");
                    }
                } else {
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
                        kiosk.subInventory(count);

                        //Data체킹
                        System.out.println("\n========HereOrder=========");
                        System.out.println("주문음료 = " + orderService.getOrderMenu());
                        System.out.println("주문개수 = " + orderService.getOrderCnt());
                        System.out.println("총 주문가격 = " + orderService.getTotalPrice());
                        System.out.println("주문번호= " + ((HereOrder) orderService).getOrderNum());
                        System.out.println("=============================\n");

                    } else {
                        System.out.println("금액이 부족합니다.");
                    }
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
                System.out.println("error code: "+e.code);
            }
        }
    }
}
