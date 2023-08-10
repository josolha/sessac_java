package example0810.ott;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Series extends Contents{
    private List<String> seriesId;
}

