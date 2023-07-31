package example0731;

public class TakeoutOrder extends Order implements OnTakeout{

    private int time;

    private static final int TAKEOUT_FEE = 500;
    private final OnTakeout onTakeout;

    public TakeoutOrder(String menu, int orderCnt, int orderPrice, OnTakeout takeout) {
        super(menu, orderCnt, orderPrice);
        this.onTakeout = takeout;
    }

    @Override
    int calculateTotalPrice() {
        return super.orderCnt * super.unitPrice - TAKEOUT_FEE;
    }

    @Override
    boolean runOrder(int paymentAmount) {
        return paymentAmount >= super.totalPrice;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /*  public int getTime() {
        return time;
    }*/

    @Override
    public void successTakeout() {
        System.out.print(time+" 분뒤 "+super.orderMenu);
        onTakeout.successTakeout();
    }
}
