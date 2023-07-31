package example0728;

public class Order {
    private String orderMenu;
    public int orderCnt;
    public int orderPrice;

    public Order(String menu, int orderCnt, int orderPrice) {
        this.orderMenu = menu;
        this.orderCnt = orderCnt;
        this.orderPrice = orderPrice;
    }
    public void setOrderPrice() {
        this.orderPrice = this.orderCnt * this.orderPrice;
    }
    public boolean runOrder(int depositMoney) {
        return depositMoney >= orderPrice;
    }
    public int getOrderPrice() {
        return orderPrice;
    }

    public String getOrderMenu() {
        return orderMenu;
    }

    public int getOrderCnt() {
        return orderCnt;
    }
}
