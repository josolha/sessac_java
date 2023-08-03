package example0802.kiosk;

import lombok.Builder;
import lombok.experimental.SuperBuilder;


public class HereOrder extends Order {

    private int orderNum;

    private final OnHere onHere;

    public HereOrder(Menu[] menu, OnHere onHere) {
        super(menu);
        this.onHere = onHere;
    }

    @Override
    void calculateTotalPrice() {
        super.calculateTotalPrice();
    }

    @Override
    boolean runOrder(int paymentAmount) {
        return paymentAmount >= super.totalPrice;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }


   public int getOrderNum() {
        return orderNum;
    }

    public void successHere() {
        onHere.successHere(this.orderNum, super.orderMenu);
    }
}
