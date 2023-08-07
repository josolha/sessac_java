package example0807.kiosk;


import java.util.List;

public class HereOrder extends Order {

    private int orderNum;

    private final OnHere onHere;

    public HereOrder(List<Menu> menu, OnHere onHere) {
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

    @Override
    void outOrder() {
        onHere.orderHereWait(this.orderNum,super.orderMenu);
    }
   public int getOrderNum() {
        return orderNum;
    }

    public void successHere() {
        onHere.successHere(this.orderNum, super.orderMenu);
    }
}
