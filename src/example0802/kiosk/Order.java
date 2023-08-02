package example0802.kiosk;

import lombok.Builder;
import lombok.experimental.SuperBuilder;


@SuperBuilder
public abstract class Order {

    protected Menu[] orderMenu;
//    protected int orderCnt;
    protected int totalPrice;


//    public Order(Menu[] menus, int unitPrice) {
//        this.orderMenu = menus;
////        this.orderCnt = orderCnt;
//        this.unitPrice = unitPrice;
//    }

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

    public Menu[] getOrderMenu() {
        return orderMenu;
    }

}
