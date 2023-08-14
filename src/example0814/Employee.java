package example0814;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Employee {
    private String name;
    private int sabun;
    private String phone;
    private String addr;

    public String toStringForTotal() {
        return
                "  이름 =" + name +
                ", 사원 번호 =" + sabun;
    }
    public String toStringForOne(){
        return   "  이름 =" + name +
                 ", 사원 번호 =" + sabun +
                 ", 휴대폰 번호 =" + phone +
                 ", 주소 =" + addr;
    }

}
