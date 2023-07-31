package example0731;

public class OrderFactory implements OnHere, OnTakeout, OnDelivery {

    public Order createOrder(String type, String menu, int count, int price) {
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
    public void successHere() {
        System.out.println(" 주문 완료되었습니다.");
    }
    @Override
    public void successDelivery() {
        System.out.println(" 배달 주문이 완료했습니다.");
    }
    @Override
    public void successTakeout() {
        System.out.println(" 포장주문 완료되었습니다.");
    }
}
