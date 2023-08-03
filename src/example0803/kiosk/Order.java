package example0803.kiosk;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public abstract class Order {

    protected List<Menu> orderMenu;
    protected int totalPrice;

    public Order(List<Menu> menus) {
        this.orderMenu = menus;
    }

    void calculateTotalPrice(){
        int price = 0;
        for (Menu menu : orderMenu) {
            price += menu.price;
        }
        this.totalPrice = price;
    }

    abstract boolean runOrder(int paymentAmount);

    public int getTotalPrice() {
        return totalPrice;
    }
    public List<Menu> getOrderMenu() {
        return orderMenu;
    }

}