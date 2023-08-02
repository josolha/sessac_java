package example0802.kiosk;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderParameters {
    private int type;
    private Menu[] menu;
    private String location;  // For DeliveryOrder
    private int orderNum;     // For HereOrder
    private int time;        // For TakeOutOrder
}
