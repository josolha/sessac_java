package example0731;

public class OrderFactory implements OnHere, OnTakeout, OnDelivery {

    public Order createOrder(String type, String menu, int count, int price) {
        switch (type) {
            case "Delivery":
                DeliveryOrder deliveryOrder = new DeliveryOrder(menu, count, price, this);
                return deliveryOrder;
            case "HereOrder":
                HereOrder hereOrder = new HereOrder(menu, count, price, this);
                return hereOrder;
            case "TakeoutOrder":
                TakeoutOrder takeoutOrder = new TakeoutOrder(menu, count, price, this);
                return takeoutOrder;
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
