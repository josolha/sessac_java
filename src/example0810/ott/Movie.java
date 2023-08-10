package example0810.ott;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie extends Contents {
    private String originalId;
    private String trailerId;
}
