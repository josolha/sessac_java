package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Series extends Contents{
    private List<String> seriesId;



    public Series(String id, String title, String direc, String year, String summary, String cast, int views, String type, List<String> mediaId, List<String> seriesId) {
        super(id, title, direc, year, summary, cast, views, type, mediaId);
        this.seriesId = seriesId;
    }
    @Override
    public String toString() {
        return "Series { " +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", direc='" + direc + '\'' +
                ", year='" + year + '\'' +
                ", summary='" + summary + '\'' +
                ", cast='" + cast + '\'' +
                ", views=" + views +
                ", type=" + type +
                ", mediaId=" + mediaId +
                ", seriesId='" + seriesId.toString() + '\'' +
                " }";
    }
    public List<String> getSeriesId() {
        return seriesId;
    }
}

