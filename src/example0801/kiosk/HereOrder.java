package example0801.kiosk;

public class HereOrder extends Order {

    private int orderNum;

    private final OnHere onHere;

    public HereOrder(Menu[] menu, int orderCnt, int orderPrice, OnHere onHere) {
        super(menu, orderCnt, orderPrice);
        this.onHere = onHere;
    }

    @Override
    int calculateTotalPrice() {
        return super.orderCnt * super.unitPrice;
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
