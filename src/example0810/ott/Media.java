package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Media {
    private String id;
    private String title;
    private String time;
    private String cId;
    private OnPlay onPlay;

    public Media(String id, String title, String time, String cId, OnPlay onPlay) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.cId = cId;
        this.onPlay = onPlay;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getcId() {
        return cId;
    }

    public OnPlay getOnPlay() {
        return onPlay;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", cId='" + cId + '\'' +
                ", onPlay=" + onPlay +
                '}';
    }
}
