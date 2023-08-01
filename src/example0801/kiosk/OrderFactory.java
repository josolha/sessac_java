package example0801.kiosk;

public class OrderFactory implements OnHere, OnTakeout, OnDelivery {

    public Order createOrder(String type, Menu[] menu, int count, int price) {
        switch (type) {
            case "Delivery":
                return new DeliveryOrder(menu, count, price, this);
            case "HereOrder":
                return new HereOrder(menu, count, price, this);
            case "TakeoutOrder":
                return new TakeoutOrder(menu, count, price, this);
            default:
                return null;
        }
    }
    @Override
    public void successHere(int orderNum, Menu[] menu) {
        System.out.print(orderNum+" 주문번호로 "+menu+" 주문 완료 되었습니다");
    }
    @Override
    public void successDelivery(String locate, Menu[] menu ) {
        System.out.println(locate+" 주소로"+menu+" 배달 주문이 완료했습니다.");
    }
    @Override
    public void successTakeout(int time, Menu[] menu) {
        System.out.println(time+" 분뒤 "+menu+" 포장주문 완료되었습니다.");
    }
}
