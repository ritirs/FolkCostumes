package ee.bcs.folkcostumes.locationManagement.locationBalance;

import lombok.Data;

import java.io.Serializable;

@Data
public class LocationBalanceStatement implements Serializable {
    private final String locationLocation;
    private final String username;
    private final String elementElementName;
    private final String elementDescription;
    private final Integer quantity;
}
