package example0728;

public class TakeoutOrder extends Order{
    private int time;

    public TakeoutOrder(String menu, int count, int price) {
        super(menu, count, price);

    }
    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
    @Override
    public void setOrderPrice() {
        super.setOrderPrice();
        super.orderPrice -= 500;
    }

}
