package example0803.kiosk;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Kiosk implements OnHere, OnTakeout, OnDelivery {
    protected Deque<String> orderWating = new LinkedList<>();
    private int inventory;

    private List<Menu> menuList = new ArrayList<>();

    public Kiosk(int inventory) {
        this.inventory = inventory;
    }

    public Order initOrder (String type) throws CustomException  {

        switch (type) {
            case "Delivery":
                return new DeliveryOrder(menuList, this);
            case "TakeoutOrder":
                return new TakeoutOrder(menuList, this);
            case "HereOrder":
                return new HereOrder(menuList, this);
            default:
                throw new CustomException("해당 서비스는 없습니다.",103);
        }
    }
    public void addMenus(String menuName) throws CustomException {
        menuList.add(new Menu(menuName));
    }
    public int getMenusSize(){
        return this.menuList.size();
    }
    public void clearMenuList() {
        this.menuList.clear();
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
    public void successHere(int orderNum, List<Menu> menu) {
        System.out.print(orderNum+" 주문번호로 "+ menu.toString().replace("[","").replace("]","") +" 주문 완료 되었습니다");
        checkWaiting("매장 :"+ orderNum + " 번호 주문 메뉴 나왔습니다.");
    }
    @Override
    public void successDelivery(String locate, List<Menu> menu ) {
        System.out.println(locate+" 주소로 "+menu.toString().replace("[","").replace("]","")+" 배달 주문이 완료했습니다.");
        checkWaiting("배달 :" + locate+" 주소로 배달이 시작되었습니다.");
    }
    @Override
    public void successTakeout(int time, List<Menu> menu) {
        System.out.println(time+" 분뒤 "+menu.toString().replace("[","").replace("]","")+" 포장주문 완료되었습니다.");
        checkWaiting("포장 : 포장 주문 하신 메뉴 나왔습니다.");
    }
    public void checkWaiting(String a){
        if(orderWating.size() ==3){
            orderWating.poll();
            orderWating.add(a);
        }else{
            orderWating.add(a);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String order : orderWating) {
            sb.append(order).append("\n");
        }
        return sb.toString();
    }
}

