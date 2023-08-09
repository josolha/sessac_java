package example0810.kiosk;

public class Menu {

    public int totalPrice;
    private final String menu;

    public int cnt;
    public Menu(String menu, int price, int cnt)  {
        //메뉴 이름, 가격(총가격), 개수
        this.menu = menu;
        this.cnt = cnt;
        this.totalPrice = price * cnt;
    }
    @Override
    public String toString() {
        return this.menu + this.cnt+"개";
    }

    public String getMenu() {
        return menu;
    }

    public int getCnt() {
        return cnt;
    }
}
