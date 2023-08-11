package example0810.ott;


import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
public class Movie extends Contents {
    private String originalId;
    private String trailerId;

    public Movie(String id, String title, String direc, String year, String summary, String cast, int views, String type, List<String> mediaId, String originalId, String trailerId) {
        super(id, title,direc, year, summary, cast, views, type, mediaId);
        this.originalId = originalId;
        this.trailerId = trailerId;
    }
    @Override
    public String toString() {
        return "Movie { " +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", direc='" + direc + '\'' +
                ", year='" + year + '\'' +
                ", summary='" + summary + '\'' +
                ", cast='" + cast + '\'' +
                ", views=" + views +
                ", type=" + type +
                ", mediaId=" + mediaId +
                ", originalId='" + originalId + '\'' +
                ", trailerId='" + trailerId + '\'' +
                " }";
    }
    public String getOriginalId() {
        return originalId;
    }

    public String getTrailerId() {
        return trailerId;
    }
}
