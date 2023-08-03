package example0802.kiosk;

import java.util.Arrays;
import java.util.List;

public class Kiosk implements OnHere, OnTakeout, OnDelivery {
    private int inventory;

    public Kiosk(int inventory) {
        this.inventory = inventory;
    }

    public Order initOrder (String type, Menu[] menus)  {
        switch (type) {
            case "Delivery":
                return new DeliveryOrder(menus, this);
            case "TakeoutOrder":
                return new TakeoutOrder(menus, this);
            case "HereOrder":
                return new HereOrder(menus, this);
            default:
                return null;
        }
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
        System.out.print(orderNum+" 주문번호로 "+ Arrays.toString(menu).replace("[","").replace("]","") +" 주문 완료 되었습니다");
    }
    @Override
    public void successDelivery(String locate, Menu[] menu ) {
        System.out.println(locate+" 주소로"+Arrays.toString(menu).replace("[","").replace("]","")+" 배달 주문이 완료했습니다.");
    }
    @Override
    public void successTakeout(int time, Menu[] menu) {
        System.out.println(time+" 분뒤 "+Arrays.toString(menu).replace("[","").replace("]","")+" 포장주문 완료되었습니다.");
    }
}

