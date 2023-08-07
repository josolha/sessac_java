package example0803.kiosk;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Kiosk implements OnHere, OnTakeout, OnDelivery {
    public Deque<Order> orderWating = new LinkedList<>();

    //메뉴  이름 , 가격
    //메뉴  이름 , 재고개수
    private int inventory;
    private static final int MAX_ORDER_WAIT_COUNT = 3;

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
    }

    @Override
    public void orderHereWait(int orderNum, List<Menu> menu) {
        System.out.println(
                "\n------------------------" +
                "\n주문하신 "+ menu.size() +"메뉴 " +
                "\n매장 :"+ orderNum + " 번호 주문 메뉴 나왔습니다."+
                "\n------------------------ ");
    }
    @Override
    public void successDelivery(String locate, List<Menu> menu ) {
        System.out.println(locate+" 주소로 "+menu.toString().replace("[","").replace("]","")+" 배달 주문이 완료했습니다.");

    }
    @Override
    public void orderDeliveryWait(String locate, List<Menu> menu) {
        System.out.println(
                    "\n------------------------" +
                    "\n주문하신 "+ menu.size() +"메뉴 " +
                    "\n배달 :" + locate+" 주소로 배달이 시작되었습니다."+
                    "\n------------------------ ");
    }
    @Override
    public void successTakeout(int time, List<Menu> menu) {
        System.out.println(time+" 분뒤 "+menu.toString().replace("[","").replace("]","")+" 포장주문 완료되었습니다.");
    }
    @Override
    public void orderTakeoutWait(int time, List<Menu> menu) {
        System.out.println(
                "\n------------------------" +
                "\n주문하신 "+ menu.size() +"메뉴 " +
                "\n포장 : "+time+"이 지나 포장 주문 하신 메뉴 나왔습니다."+
                "\n------------------------ ");
    }
     public void printWaitOver(){
        if(orderWating.size() == MAX_ORDER_WAIT_COUNT){
            Order orderSerive = orderWating.pollFirst();
            orderSerive.outOrder();
        }
    }
    public void orderWaitStatus(){
        System.out.println("=======ORDER WAIT CHECK=======");
        for (Order order: orderWating) {
             order.outOrder();
        }
        System.out.println("=============================");
    }

}

