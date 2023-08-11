package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User implements OnWish{
    private int id;
    private String name;
    private List<String> wishList;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.wishList = new ArrayList<>();
    }
    public void addWishList(String cId){
        wishList.add(cId);
    }

}
