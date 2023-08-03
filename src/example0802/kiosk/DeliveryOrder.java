package example0802.kiosk;


public class DeliveryOrder extends Order {

    private final OnDelivery onDelivery;
    private int deliveryFee = 3000;
    protected String locate;

   public DeliveryOrder(Menu[] menu, OnDelivery delivery) {
        super(menu);
        this.onDelivery = delivery;
    }

    @Override
    void calculateTotalPrice() {
        super.calculateTotalPrice();
        super.totalPrice = super.totalPrice+ deliveryFee;
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

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void successDelivery() {
        onDelivery.successDelivery(this.locate, super.orderMenu);
    }

}

