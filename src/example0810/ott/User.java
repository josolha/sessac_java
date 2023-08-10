package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private List<String> wishList;
    private OnWish onWish;
}
