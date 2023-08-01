package example0731;

import example0731.CustomException;

import java.util.HashMap;
import java.util.Map;

public class Kiosk {
    private int inventory;
    private final Map<String,Integer> orderHashMap;

    public Kiosk(int inventory) {

        this.inventory = inventory;
        orderHashMap = new HashMap<>();
        orderHashMap.put("딸기요거트", 4500);
        orderHashMap.put("밀크티", 3500);
        orderHashMap.put("카페라떼", 3500);
        orderHashMap.put("아메리카노", 2000);
    }

    public Order initOrder (String type, String menu, int initCnt) throws CustomException{
        int price = 0;
        if(orderHashMap.containsKey(menu)) {
            price = orderHashMap.get(menu);
        }else {
            throw new CustomException("메뉴가 없습니다",101);
        }
        OrderFactory orderFactory = new OrderFactory();
        return orderFactory.createOrder(type, menu, initCnt, price);
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

