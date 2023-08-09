package example0810.kiosk;

import java.util.List;

public interface OnHere {
    void successHere(int orderNum, List<Menu> menu);
    void orderHereWait(int orderNum, List<Menu> menu);
}
