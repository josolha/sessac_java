package example0810.kiosk;


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
            price += menu.totalPrice;
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

    abstract void outOrder();

}
