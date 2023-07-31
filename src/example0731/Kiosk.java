package example0731;

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

    public Order initOrder (String type, String menu, int initCnt){
        int price = 0;
        if(orderHashMap.containsKey(menu)) {
            price = orderHashMap.get(menu);
        }else {
            return null;
        }
        OrderFactory orderFactory = new OrderFactory();
        return orderFactory.createOrder(type, menu, initCnt, price);
    }

    public boolean isInventory(int count) {
        return inventory >= count;
    }

    public void subInventory(int count) {
        inventory -= count;
    }
}

