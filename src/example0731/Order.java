package example0731;

public abstract class Order {
    protected String orderMenu;
    protected int orderCnt;

    protected int unitPrice;

    protected int totalPrice;

    public Order(String menu, int orderCnt, int unitPrice) {
        this.orderMenu = menu;
        this.orderCnt = orderCnt;
        this.unitPrice = unitPrice;
        this.totalPrice = calculateTotalPrice();
    }
    abstract int calculateTotalPrice();

    abstract boolean runOrder(int paymentAmount);

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getOrderMenu() {
        return orderMenu;
    }

    public int getOrderCnt() {
        return orderCnt;
    }
}
