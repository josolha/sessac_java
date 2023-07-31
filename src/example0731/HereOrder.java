package example0731;

public class HereOrder extends Order implements OnHere{

    int orderNum;

    public OnHere onHere;

    public HereOrder(String menu, int orderCnt, int orderPrice,OnHere onHere) {
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

    public void setOnHere(OnHere onHere) {
        this.onHere = onHere;
    }

    public int getOrderNum() {
        return orderNum;
    }

    @Override
    public void successHere() {
        System.out.print(orderNum+" 주문번호로 "+super.orderMenu);
        onHere.successHere();
    }
}
