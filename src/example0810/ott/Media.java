package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Media {
    private String id;
    private String name;
    private String contentsId;
    private OnPlay onPlay;
}
