package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class Contents {
    private String id;
    private String title;
    private String year;
    private String summary;
    private String cast;
    private int views;
    private List<String> mediaId;
}
