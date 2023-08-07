package example0807.kiosk;

import java.util.List;

public interface OnDelivery  {

    void successDelivery(String locate, List<Menu> menu);
    void orderDeliveryWait(String locate, List<Menu> menu);
}
