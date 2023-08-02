package example0802.kiosk;

import java.util.Arrays;

public class OrderFactory implements OnHere, OnTakeout, OnDelivery {

    public Order createOrder(OrderParameters params) {

        switch (params.getType()) {
            case 1:
                return DeliveryOrder.builder()
                        .orderMenu(params.getMenu())
                        .onDelivery(this)
                        .build();
            case 2:
                return HereOrder.builder()
                        .orderMenu(params.getMenu())
                        .onHere(this)
                        .orderNum(params.getOrderNum())
                        .build();
            case 3:
                return TakeoutOrder.builder()
                        .orderMenu(params.getMenu())
                        .onTakeout(this)
                        .time(params.getTime())
                        .build();
            default:
                return null;
        }
    }
    @Override
    public void successHere(int orderNum, Menu[] menu) {
        System.out.print(orderNum+" 주문번호로 "+menu.toString()+" 주문 완료 되었습니다");
    }
    @Override
    public void successDelivery(String locate, Menu[] menu ) {
        System.out.println(locate+" 주소로 배달 주문이 완료했습니다.");
        System.out.println("주문 내역은 : "+Arrays.toString(menu).replace("[","").replace("]",""));

    }
    @Override
    public void successTakeout(int time, Menu[] menu) {
        System.out.println(time+" 분뒤 "+menu+" 포장주문 완료되었습니다.");
    }
}
