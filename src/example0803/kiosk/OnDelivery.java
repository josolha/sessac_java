package example0803.kiosk;

import java.util.List;

public interface OnDelivery {

    void successDelivery(String locate, List<Menu> menu);
}
