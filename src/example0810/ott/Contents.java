package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
public class Contents {
    protected String id;
    protected String direc;
    protected String title;
    protected String year;
    protected String summary;
    protected String cast;
    protected int views;
    protected String type;
    protected List<String> mediaId;
    private OnWish onWish;

    public Contents(String id,String title,String direc, String year, String summary, String cast, int views, String type, List<String> mediaId) {
        this.id = id;
        this.direc =direc;
        this.title = title;
        this.year = year;
        this.summary = summary;
        this.cast = cast;
        this.views = views;
        this.type = type;
        this.mediaId = mediaId;
    }
    public void increaseViews() {
        this.views += 1;
    }

    public void setOnWish(OnWish onWish) {
        this.onWish = onWish;
    }

    public void addWish() {
        onWish.addWishList(id);
    }
}
