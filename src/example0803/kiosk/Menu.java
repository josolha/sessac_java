package example0803.kiosk;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    public int price;
    private String menu;

    public Menu(String menu) throws CustomException {
        this.menu = menu;

        Map<String,Integer> orderHashMap = new HashMap<>();
        orderHashMap.put("딸기요거트", 4500);
        orderHashMap.put("밀크티", 3500);
        orderHashMap.put("카페라떼", 3500);
        orderHashMap.put("아메리카노", 2000);

        if(orderHashMap.containsKey(menu)) {
            this.price = orderHashMap.get(menu);
        }else {
            throw new CustomException("메뉴가 없습니다",101);
        }
    }

    @Override
    public String toString() {
        return this.menu;
    }
}
