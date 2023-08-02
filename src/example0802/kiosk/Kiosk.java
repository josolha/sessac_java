package example0802.kiosk;

import java.util.List;

public class Kiosk implements OnHere, OnTakeout, OnDelivery {
    private int inventory;

    public Kiosk(int inventory) {
        this.inventory = inventory;
    }

    public Order initOrder (OrderParameters params) throws CustomException {
        OrderFactory orderFactory = new OrderFactory();
        return orderFactory.createOrder(params);
    }
    public Menu[] setMenus(List<String> menuNames) throws CustomException {

        Menu[] menus = new Menu[menuNames.size()];
        for (int i = 0; i < menuNames.size(); i++) {
            menus[i] = new Menu(menuNames.get(i));
        }
        return menus;
    }
    public boolean isInventory(int count) throws CustomException {
        if(inventory<count){
         throw new CustomException("재고가 부족합니다",102);
        }
        return true;
    }
    public void subInventory(int count) {
        inventory -= count;
    }

    @Override
    public void successHere(int orderNum, Menu[] menu) {
        System.out.print(orderNum+" 주문번호로 "+menu+" 주문 완료 되었습니다");
    }
    @Override
    public void successDelivery(String locate, Menu[] menu ) {
        System.out.println(locate+" 주소로"+menu+" 배달 주문이 완료했습니다.");
    }
    @Override
    public void successTakeout(int time, Menu[] menu) {
        System.out.println(time+" 분뒤 "+menu+" 포장주문 완료되었습니다.");
    }
}

