package example0731;

public class DeliveryOrder extends Order{

    private final OnDelivery onDelivery;
    private static final int DELIVERY_FEE = 3000;

    protected String locate;

    public DeliveryOrder(String menu, int orderCnt, int orderPrice, OnDelivery delivery) {
        super(menu, orderCnt, orderPrice);
        this.onDelivery = delivery;
    }
    @Override
    int calculateTotalPrice() {
        return super.orderCnt * super.unitPrice + DELIVERY_FEE;
    }
    @Override
    boolean runOrder(int paymentAmount) {
        return paymentAmount == super.getTotalPrice();
    }
    public void setLocate(String locate) {
        this.locate = locate;
    }
    public String getLocate() {
        return locate;
    }

    public void successDelivery() {
        onDelivery.successDelivery(this.locate,super.orderMenu);
    }

}

