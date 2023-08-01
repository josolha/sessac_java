package example0801.kiosk;

import java.util.HashMap;
import java.util.Map;

public class Kiosk {
    private int inventory;

    public Kiosk(int inventory) {

        this.inventory = inventory;
    }

    public Order initOrder (String type, String menu, int initCnt) throws CustomException {
        Menu[] menus = new Menu[10];
        int price = 0;
        for (int i = 0; i < 10; i++) {
            menus[i] = new Menu(menu);
            price +=menus[i].price;
        }
        OrderFactory orderFactory = new OrderFactory();
        return orderFactory.createOrder(type, menus, initCnt, price);
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
}

