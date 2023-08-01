package example0801.kiosk;

import java.util.Arrays;

public abstract class Order {

    protected Menu[] orderMenu;
    protected int orderCnt;

    protected int unitPrice;

    protected int totalPrice;

    public Order(Menu[] menus, int orderCnt, int unitPrice) {
        this.orderMenu = menus;
        this.orderCnt = orderCnt;
        this.unitPrice = unitPrice;
        this.totalPrice = calculateTotalPrice();
    }
    abstract int calculateTotalPrice();

    abstract boolean runOrder(int paymentAmount);

    public int getTotalPrice() {
        return totalPrice;
    }

    public Menu[] getOrderMenu() {
        return orderMenu;
    }
    public int getOrderCnt() {
        return orderCnt;
    }
}
