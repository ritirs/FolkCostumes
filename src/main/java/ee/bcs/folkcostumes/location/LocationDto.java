package ee.bcs.folkcostumes.location;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocationDto implements Serializable {
    private final Integer id;
    private final String location;
}
