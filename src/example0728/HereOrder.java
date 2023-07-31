package example0728;


public class HereOrder extends Order{
    private int orderNum;
    public HereOrder(String menu, int count, int price) {
        super(menu,count,price);
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getOrderNum() {
        return orderNum;
    }
}
