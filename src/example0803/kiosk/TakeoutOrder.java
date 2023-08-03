package example0803.kiosk;


import java.util.List;

public class TakeoutOrder extends Order {

    private int time;

    private static final int TAKEOUT_FEE = 500;
    private final OnTakeout onTakeout;

    public TakeoutOrder(List<Menu> menu, OnTakeout takeout) {
        super(menu);
        this.onTakeout = takeout;
    }

    @Override
    void calculateTotalPrice() {
        super.calculateTotalPrice();
        super.totalPrice -= TAKEOUT_FEE;
    }

    @Override
    boolean runOrder(int paymentAmount) {
        return paymentAmount >= super.totalPrice;
    }

    public void setTime(int time) {
        this.time = time;
    }

     public int getTime() {
        return time;
    }

    public void successTakeout() {
        onTakeout.successTakeout(this.time, super.orderMenu);
    }
}
