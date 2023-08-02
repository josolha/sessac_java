package example0802.kiosk;


import lombok.Builder;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class DeliveryOrder extends Order {

    private final OnDelivery onDelivery;
    private static final int DELIVERY_FEE = 3000;
    protected String locate;

//    public DeliveryOrder(Menu[] menu, int orderPrice, OnDelivery delivery, String locate) {
//        super(menu, orderPrice);
//        this.onDelivery = delivery;
//        this.locate = locate;
//    }

    @Override
    void calculateTotalPrice() {
        super.calculateTotalPrice();
        super.totalPrice = super.totalPrice+ DELIVERY_FEE;
    }
    @Override
    boolean runOrder(int paymentAmount) {
        return paymentAmount == super.getTotalPrice();
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public void successDelivery() {
        onDelivery.successDelivery(this.locate, super.orderMenu);
    }

}

