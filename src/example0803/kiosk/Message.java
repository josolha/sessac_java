package example0803.kiosk;

public enum Message {
    INVENTORY_MSG("매장 재고개수를 입력해주세요"),
    ORDER_TYPE_MSG ("1.배달 2.포장 3.매장 주문방식 번호를 입력해주세요"),
    MENU_MSG ("메뉴 또는 주문을 입력해주세요"),
    INVALID_SERVICE_MSG ("없는 주문 서비스 입니다.");

    private final String message;

    Message(String message) {
        this.message =message;
    }
    public String getMessage(){
        return this.message;
    }
}
