package example0802.kiosk;




public abstract class Order {

    protected Menu[] orderMenu;
    protected int totalPrice;

    public Order(Menu[] menus) {
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
    public Menu[] getOrderMenu() {
        return orderMenu;
    }

}
