package example0728;

public class DeliveryOrder extends Order{

    private String locate;

    public DeliveryOrder(String menu, int orderCnt, int price) {
        super(menu, orderCnt, price);
    }
    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getLocate() {
        return locate;
    }

    @Override
    public void setOrderPrice() {
        super.setOrderPrice();
        super.orderPrice += 3000;
    }
    @Override
    public boolean runOrder(int depositMoney) {
        return depositMoney == super.getOrderPrice();
    }
}
